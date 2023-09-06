import java.util.UUID;

import java.util.ArrayList;

public class AlunoController {
    private final ArrayList<Aluno> alunos;

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public AlunoController() {
        this.alunos = new ArrayList<>();
    }

    public boolean addAluno(String nome, String endereco, int idade){
        if(nome == null || nome.length() < 3) return false;
        if(endereco == null || endereco.isEmpty()) return false;
        if(idade <= 0) return false;

        Aluno aluno = new Aluno(endereco, idade, nome, UUID.randomUUID());

        alunos.add(aluno);
        return true;
    }
}
