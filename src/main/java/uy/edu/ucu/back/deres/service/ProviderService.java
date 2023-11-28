package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.back.deres.entity.Answer;
import uy.edu.ucu.back.deres.entity.Provider;
import uy.edu.ucu.back.deres.entity.Question;
import uy.edu.ucu.back.deres.model.provider.ProviderRequestDTO;
import uy.edu.ucu.back.deres.model.provider.ProviderResponseDTO;
import uy.edu.ucu.back.deres.repository.ProviderRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class ProviderService {

    String SOCIAL = "SOCIAL";
    String AMBIENTAL = "AMBIENTAL";
    String GOBERNANZA = "GOBERNANZA";

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired 
    private AnswerService answerService;

    public List<Provider> getProviders() {
        try {

            List<Provider> providers = providerRepository.findAll();
            for (Provider provider : providers) {
                var totalScore = 0.0;
                var score = getScore(provider.getRut());
                if(score.get(SOCIAL) != null && score.get(AMBIENTAL) != null && score.get(GOBERNANZA) != null){
                    totalScore = Math.round((score.get(SOCIAL) * 33.34 + score.get(AMBIENTAL) * 33.34 + score.get(GOBERNANZA) * 33.34)/100);
                }
                provider.setTotalScore(String.valueOf(totalScore));
                provider.setSocialScore(String.valueOf(score.get(SOCIAL)));
                provider.setAmbientalScore(String.valueOf(score.get(AMBIENTAL)));
                provider.setGobernanzaScore(String.valueOf(score.get(GOBERNANZA)));
            }
            return providers;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener proveedores de la base de datos.", e);
        }
    }

    public ProviderResponseDTO addProvider(ProviderRequestDTO provider) {
        try {
            var totalScore = 0.0;
            var score = getScore(provider.getRUT());
            if(score.get(SOCIAL) != null && score.get(AMBIENTAL) != null && score.get(GOBERNANZA) != null){
                totalScore = Math.round((score.get(SOCIAL) * 33.34 + score.get(AMBIENTAL) * 33.34 + score.get(GOBERNANZA) * 33.34));
            }
            var providerEntity = Provider.builder()
                    .name(provider.getName())
                    .rut(provider.getRUT())
                    .type(provider.getType())
                    .address(provider.getAddress())
                    .phone(provider.getPhone())
                    .email(provider.getEmail())
                    .contact(provider.getContact())
                    .totalScore(String.valueOf(totalScore))
                    .socialScore(String.valueOf(score.get(SOCIAL)))
                    .ambientalScore(String.valueOf(score.get(AMBIENTAL)))
                    .gobernanzaScore(String.valueOf(score.get(GOBERNANZA)))
                    .build();
            providerRepository.save(providerEntity);
            return new ProviderResponseDTO(true, provider.getRUT());
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar proveedor a la base de datos.", e);
        }
    }

    public Provider getProvider(String rut) {
        try {
            var totalScore = 0.0;
            var score = getScore(rut);
            if(score.get(SOCIAL) != null && score.get(AMBIENTAL) != null && score.get(GOBERNANZA) != null){
                totalScore = Math.round((score.get(SOCIAL) * 33.34 + score.get(AMBIENTAL) * 33.34 + score.get(GOBERNANZA) * 33.34)/100);
            }
            Provider provider = providerRepository.findByRut(rut);
            provider.setSocialScore(String.valueOf(score.get(SOCIAL)));
            provider.setAmbientalScore(String.valueOf(score.get(AMBIENTAL)));
            provider.setGobernanzaScore(String.valueOf(score.get(GOBERNANZA)));
            provider.setTotalScore(String.valueOf(totalScore));
            
            return provider;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener proveedor de la base de datos.", e);
        }
    }

    private HashMap<String, Integer> getScore(String rut) {
        try {
            HashMap<String, Integer> scores = new HashMap<String, Integer>();
            int socialScore = 0;
            int ambientalScore = 0;
            int gobernanzaScore = 0;

            var questions = questionService.getQuestions();
            var answers = answerService.getByProviderRut(rut);

            for (Answer answer : answers) {
                for (Question question : questions) {
                    if (answer.getQuestionID() == question.getId()) {
                        if (answer.getAnswer()) {
                            int ponderation = Integer.parseInt(question.getPonderation());
                            if (question.getType().equals(SOCIAL)) {
                                socialScore += ponderation;
                            } else if (question.getType().equals(AMBIENTAL)) {
                                ambientalScore += ponderation;
                            } else if (question.getType().equals(GOBERNANZA)) {
                                gobernanzaScore += ponderation;
                            }
                        }
                    }
                }
            }
            scores.put(SOCIAL, socialScore);
            scores.put(AMBIENTAL, ambientalScore);
            scores.put(GOBERNANZA, gobernanzaScore);
            return scores;
        } catch (Exception e) {
            throw new RuntimeException("Error calculando el score.", e);
        }
    }
}
