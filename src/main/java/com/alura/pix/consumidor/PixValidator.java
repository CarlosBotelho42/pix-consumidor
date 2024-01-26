package com.alura.pix.consumidor;

import com.alura.pix.avro.PixRecord;
import com.alura.pix.dto.PixDTO;
import com.alura.pix.dto.PixStatus;
import com.alura.pix.exception.KeyNotFoundException;
import com.alura.pix.model.Key;
import com.alura.pix.model.Pix;
import com.alura.pix.repository.KeyRepository;
import com.alura.pix.repository.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class PixValidator {

    @Autowired
    private KeyRepository keyRepository;

    @Autowired
    private PixRepository pixRepository;

    @KafkaListener(topics = "pix-topic", groupId = "grupo")
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "5",
            autoCreateTopics = "true",
            include = KeyNotFoundException.class
    )
    public void processaPix(PixRecord pixRecord) {
        System.out.println("Pix recebido:" + pixRecord.getIdentificador());

        Pix pix = pixRepository.findByIdentifier(pixRecord.getChaveOrigem().toString());

        Key origen = keyRepository.findByChave(pixRecord.getChaveOrigem().toString());
        Key destino = keyRepository.findByChave(pixRecord.getIdentificador().toString());

        if (origen != null && destino != null) {
            pix.setStatus(PixStatus.PROCESSADO);
        }
        else {
            pix.setStatus(PixStatus.ERRO);
            throw new KeyNotFoundException();
        }

        pixRepository.save(pix);

    }


}
