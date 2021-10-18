package com.github.blog.usecases.utils;

import com.github.blog.controllers.data.request.CommentControllerRequest;
import com.github.blog.controllers.data.request.PostControllerRequest;
import com.github.blog.controllers.data.request.UserControllerRequest;
import com.github.blog.usecases.exceptions.BadRequestErrorException;

public class ValidationUtils {

    public static void isUserValid(UserControllerRequest userControllerRequest) {
        String message = "";

        try {
            if(userControllerRequest == null) {
                message = message.concat("É necessário informar os dados do usuário.");
            } else {
                if(userControllerRequest.getName() == null || userControllerRequest.getName().isBlank()) {
                    message = message.concat(" O campo nome está nulo ou vazio.");
                }

                if (userControllerRequest.getUsername() == null || userControllerRequest.getUsername().isBlank()) {
                    message = message.concat(" O campo username está nulo ou vazio.");
                }

                if (!StringUtils.ValidationLength(userControllerRequest.getName())) {
                    message = message.concat(" No mínimo deve-se ter 3 caracteres no nome de um usuário.");
                }

                if (!StringUtils.ValidationLength(userControllerRequest.getUsername())) {
                    message = message.concat(" No mínimo deve-se ter 3 caracteres no username de um usuário.");
                }

                if (!StringUtils.ValidationEmail(userControllerRequest.getEmail())) {
                    message = message.concat(" O e-mail informado é inválido.");
                }

                if (!StringUtils.ValidationPassword(userControllerRequest.getPassword())) {
                    message = message.concat(" A senha informada é inválida, ela deve possuir letras maiúsculas e minúsculas, números e caracteres especiais..");
                }
            }

            if(!message.isBlank()) {
                throw new BadRequestErrorException(message);
            }
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException(message);
        }
    }

    public static void isPostValid(PostControllerRequest postControllerRequest) {
        String message = "";

        try {
            if(postControllerRequest == null) {
                message = message.concat("É necessário informar os dados do post.");
            } else {
                if(postControllerRequest.getTitle() == null || postControllerRequest.getTitle().isBlank()) {
                    message = message.concat(" O campo título está nulo ou vazio.");
                }

                if (postControllerRequest.getContent() == null || postControllerRequest.getContent().isBlank()) {
                    message = message.concat(" O campo conteúdo está nulo ou vazio.");
                }

                if (postControllerRequest.getAuthor() == null || postControllerRequest.getAuthor().isBlank()) {
                    message = message.concat(" O campo do nome do autor está nulo ou vazio.");
                }

                if (!StringUtils.ValidationLength(postControllerRequest.getContent())) {
                    message = message.concat(" No mínimo deve-se ter 3 caracteres no conteúdo de um post.");
                }

                if (!StringUtils.ValidationLength(postControllerRequest.getTitle())) {
                    message = message.concat(" No mínimo deve-se ter 3 caracteres no título de um post.");
                }
            }

            if(!message.isBlank()) {
                throw new BadRequestErrorException(message);
            }
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException(message);
        }
    }

    public static void isCommentValid(CommentControllerRequest commentControllerRequest) {
        String message = "";

        try {
            if(commentControllerRequest == null) {
                message = message.concat("É necessário informarar os dados do comentário.");
            } else {
                if(commentControllerRequest.getPersonName() == null || commentControllerRequest.getPersonName().isBlank()) {
                    message = message.concat(" O campo nome está nulo ou vazio.");
                }

                if (commentControllerRequest.getContent() == null || commentControllerRequest.getContent().isBlank()) {
                    message = message.concat(" O campo conteúdo está nulo ou vazio.");
                }

                if (!StringUtils.ValidationLength(commentControllerRequest.getContent())) {
                    message = message.concat(" No mínimo deve-se ter 3 caracteres em um comentário.");
                }
            }

            if(!message.isBlank()) {
                throw new BadRequestErrorException();
            }
        } catch (BadRequestErrorException ex) {
            throw new BadRequestErrorException(message);
        }
    }

}
