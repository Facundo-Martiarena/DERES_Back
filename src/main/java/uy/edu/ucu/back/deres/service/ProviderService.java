package uy.edu.ucu.back.deres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.back.deres.entity.Provider;
import uy.edu.ucu.back.deres.entity.Question;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.provider.ProviderRequestDTO;
import uy.edu.ucu.back.deres.repository.ProviderRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class ProviderService {

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
                if(score.get("social") != null && score.get("ambiental") != null && score.get("gobernanza") != null){
                    totalScore = Math.round((score.get("social") * 33.34 + score.get("ambiental") * 33.34 + score.get("gobernanza") * 33.34));
                }
                provider.setTotalScore(String.valueOf(totalScore));
                provider.setSocialScore(String.valueOf(score.get("social")));
                provider.setAmbientalScore(String.valueOf(score.get("ambiental")));
                provider.setGobernanzaScore(String.valueOf(score.get("gobernanza")));
            }
            return providers;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener proveedores de la base de datos.", e);
        }
    }

    public ResponseOK addProvider(ProviderRequestDTO provider) {
        try {
            var totalScore = 0.0;
            var score = getScore(provider.getRUT());
            if(score.get("social") != null && score.get("ambiental") != null && score.get("gobernanza") != null){
                totalScore = Math.round((score.get("social") * 33.34 + score.get("ambiental") * 33.34 + score.get("gobernanza") * 33.34));
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
                    .socialScore(String.valueOf(score.get("social")))
                    .ambientalScore(String.valueOf(score.get("ambiental")))
                    .gobernanzaScore(String.valueOf(score.get("gobernanza")))
                    .build();
            providerRepository.save(providerEntity);
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar proveedor a la base de datos.", e);
        }
    }

    public Provider getProvider(String rut) {
        try {
            var score = getScore(rut);
            var totalScore = Math.round((score.get("social") * 33.34 + score.get("ambiental") * 33.34 + score.get("gobernanza") * 33.34));
            Provider provider = providerRepository.findByRut(rut);
            provider.setSocialScore(String.valueOf(score.get("social")));
            provider.setAmbientalScore(String.valueOf(score.get("ambiental")));
            provider.setGobernanzaScore(String.valueOf(score.get("gobernanza")));
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

            for (var answer : answers) {
                Question question = questions.stream().filter(q -> q.getId() == answer.getQuestionID()).findFirst().get();
                if (answer.getAnswer()) {
                    int ponderation = Integer.parseInt(question.getPonderation());
                    if (question.getType().equals("SOCIAL")) {
                        socialScore += ponderation;
                    } else if (question.getType().equals("AMBIENTAL")) {
                        ambientalScore += ponderation;
                    } else if (question.getType().equals("GOBERNANZA")) {
                        gobernanzaScore += ponderation;
                    }
                }
            }
            scores.put("SOCIAL", socialScore);
            scores.put("AMBIENTAL", ambientalScore);
            scores.put("GOBERNANZA", gobernanzaScore);
            return scores;
        } catch (Exception e) {
            throw new RuntimeException("Error calculando el score.", e);
        }
    }
}
