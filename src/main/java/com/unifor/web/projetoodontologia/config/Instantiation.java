package com.unifor.web.projetoodontologia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

import com.unifor.web.projetoodontologia.entities.Aluno;
import com.unifor.web.projetoodontologia.entities.Atendimento;
import com.unifor.web.projetoodontologia.entities.Disciplina;
import com.unifor.web.projetoodontologia.entities.Feedback;
import com.unifor.web.projetoodontologia.entities.Paciente;
import com.unifor.web.projetoodontologia.entities.Professor;

import com.unifor.web.projetoodontologia.repositories.AlunoRepository;
import com.unifor.web.projetoodontologia.repositories.AtendimentoRepository;
import com.unifor.web.projetoodontologia.repositories.DisciplinaRepository;
import com.unifor.web.projetoodontologia.repositories.FeedbackRepository;
import com.unifor.web.projetoodontologia.repositories.PacienteRepository;
import com.unifor.web.projetoodontologia.repositories.ProfessorRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {
        alunoRepository.deleteAll();
        atendimentoRepository.deleteAll();
        disciplinaRepository.deleteAll();
        feedbackRepository.deleteAll();
        pacienteRepository.deleteAll();
        professorRepository.deleteAll();

        // Instanciando Alunos
        Aluno a1 = new Aluno(null, 123, 1, "João Silva");
        Aluno a2 = new Aluno(null, 321, 2, "Ana Souza");
        alunoRepository.saveAll(Arrays.asList(a1, a2));

        // Instanciando Professores
        Professor p1 = new Professor(null, "Carlos Mendes", "Matemática");
        Professor p2 = new Professor(null, "Mariana Costa", "Física");
        professorRepository.saveAll(Arrays.asList(p1, p2));

        // Instanciando Disciplinas
        Disciplina d1 = new Disciplina(null, "Cálculo I", "Turma A");
        Disciplina d2 = new Disciplina(null, "Física I", "Turma B");
        d1.getAlunos().addAll(Arrays.asList(a1, a2));
        disciplinaRepository.saveAll(Arrays.asList(d1, d2));


        // Instanciando Pacientes
        Paciente pac1 = new Paciente(null, "Lucas Pereira", 25);
        Paciente pac2 = new Paciente(null, "Fernanda Lima", 30);
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2));





        // Instanciando Feedbacks
        Feedback f1 = new Feedback(null, "Ótimo atendimento!");
        Feedback f2 = new Feedback(null, "Muito satisfeito!");
        feedbackRepository.saveAll(Arrays.asList(f1, f2));

        // Instanciando Atendimentos
        Atendimento at1 = new Atendimento(null, pac1, "Extracao Siso", f1);
        Atendimento at2 = new Atendimento(null, pac2, "Extracao Siso", f2);
        atendimentoRepository.saveAll(Arrays.asList(at1, at2));

        // Associando Alunos atendimentos
        at1.getAlunos().add(a1);
        at1.getAlunos().add(a2);

        // Associando Professores atendimentos
        at1.getProfessores().add(p1);
        at2.getProfessores().add(p2);
        at1.getProfessores().add(p2);

        // Associando Pacientes aos Atendimentos
        pac1.getAtendimentos().add(at1);
        pac2.getAtendimentos().add(at2);

        // Associando Disciplinas aos Alunos
        d1.getAlunos().add(a1);
        d1.getAlunos().add(a2);
        d2.getAlunos().add(a1);
        d2.getAlunos().add(a2);

        // Associando Disciplinas aos Professores
        d1.getProfessores().add(p1);
        d2.getProfessores().add(p2);







        feedbackRepository.saveAll(Arrays.asList(f1, f2));
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2));
        disciplinaRepository.saveAll(Arrays.asList(d1, d2));
        professorRepository.saveAll(Arrays.asList(p1, p2));
        alunoRepository.saveAll(Arrays.asList(a1, a2));
        atendimentoRepository.saveAll(Arrays.asList(at1, at2));
        pacienteRepository.saveAll(Arrays.asList(pac1, pac2));

    }
}
