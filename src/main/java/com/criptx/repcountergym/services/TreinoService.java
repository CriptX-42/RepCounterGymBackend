package com.criptx.repcountergym.services;

import com.criptx.repcountergym.domain.Cliente;
import com.criptx.repcountergym.domain.Exercicio;
import com.criptx.repcountergym.domain.Treino;
import com.criptx.repcountergym.repositories.ExercicioRepository;
import com.criptx.repcountergym.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;



    public List<Treino> list() {
        return treinoRepository.findAll();
    }

    public Treino findById(Integer id) {
        return treinoRepository.findById(id).orElseThrow(() -> new RuntimeException("treino não encontrado"));
    }

    public void delete(Integer id) {
         treinoRepository.deleteById(id);
    }

    public Treino update(Treino treino) {
        Treino newTreino = findById(treino.getId());
        updateTreino(newTreino, treino);
        updateExercicio(treino, newTreino);
        return treinoRepository.save(newTreino);
    }

    public void updateTreino(Treino updatedTreino, Treino treino) {
        updatedTreino.setNomeDeTreino(treino.getNomeDeTreino());
        updatedTreino.setNomeDoTreinador(treino.getNomeDoTreinador());
        updatedTreino.setDataInicio(treino.getDataInicio());
        updatedTreino.setDataFim(treino.getDataFim());


    }

    public void updateExercicio( Treino treino, Treino newTreino) {
        for(Exercicio exercicio : treino.getExercicio()) {
            exercicio.setTreino(treino);
            newTreino.getExercicio().add(exercicio);
        }
    }

}
