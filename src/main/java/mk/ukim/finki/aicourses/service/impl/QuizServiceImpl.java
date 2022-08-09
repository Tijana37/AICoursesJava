package mk.ukim.finki.aicourses.service.impl;

import mk.ukim.finki.aicourses.model.Quiz;
import mk.ukim.finki.aicourses.model.enums.KnowledgeLevel;
import mk.ukim.finki.aicourses.repository.QuizRepository;
import mk.ukim.finki.aicourses.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> listAllQuizes() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz create(String name, Long longitude, String level, Long minPoints, Long totalTrueAnswers) {
        return quizRepository.save(new Quiz(name, KnowledgeLevel.valueOf(level), longitude, minPoints, totalTrueAnswers) );
    }


    @Override
    public Quiz update(Long id, String name, Long longitude, String level, Long minPoints) {
        return null;
    }

    @Override
    public void delete(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Optional<Quiz> findByName(String name) {
        return quizRepository.findByName(name);

    }

    @Override
    public double isPassed(String quizName, String[] checkboxValues) {
        int total = 0;
        Quiz q = findByName(quizName).get();
        for(String s: checkboxValues){
            Integer question = Integer.parseInt(s.split("-")[0]);
            Integer answer = Integer.parseInt(s.split("-")[1]);
            if(answer==0 && q.getQuestions().get(question).getAnswers().isTrueOption1()){
                total+=1;
            } else if (answer==1 && q.getQuestions().get(question).getAnswers().isTrueOption2()) {
                total+=1;
            }
            else if (answer==2 && q.getQuestions().get(question).getAnswers().isTrueOption3()) {
                total+=1;
            }
        }

        if (total*1.0/(q.getTotalTrueAnswers())*100 > q.getMinPoints())
            return total*1.0/(q.getTotalTrueAnswers())*100 ;
        return -1.0;
    }
}
