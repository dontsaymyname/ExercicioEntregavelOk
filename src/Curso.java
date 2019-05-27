import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {

    private String nome;
    private Integer codigoDeCurso;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer qtdMaximaDeAlunos;
    private Integer qtdDeAlunos;
    List<Aluno> listaAlunosMatriculados = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public void setCodigoDeCurso(Integer codigoDeCurso) {
        this.codigoDeCurso = codigoDeCurso;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public Integer getQtdMaximaDeAlunos() {
        return qtdMaximaDeAlunos;
    }

    public void setQtdMaximaDeAlunos(Integer qtdMaximaDeAlunos) {
        this.qtdMaximaDeAlunos = qtdMaximaDeAlunos;
    }

    public Integer getQtdDeAlunos() {
        return qtdDeAlunos;
    }

    public void setQtdDeAlunos(Integer qtdDeAlunos) {
        this.qtdDeAlunos = qtdDeAlunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(codigoDeCurso, curso.codigoDeCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDeCurso);
    }

    public boolean adcionarUmAluno (Aluno aluno){
        if (listaAlunosMatriculados.size() >= qtdMaximaDeAlunos){
            return false;
        } else {
            listaAlunosMatriculados.add(aluno);
            return true;
        }
    }

    public void excluirAluno (Aluno aluno){
        listaAlunosMatriculados.remove(aluno);
        qtdDeAlunos = qtdDeAlunos - 1;

    }


}
