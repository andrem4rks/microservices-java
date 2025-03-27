package com.am.user.producer;

import com.am.user.dtos.EmailDTO;
import com.am.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        final EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso!");
        emailDTO.setText(String.format("%s, seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todas as funcionalidades.", userModel.getName()));

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }

}
