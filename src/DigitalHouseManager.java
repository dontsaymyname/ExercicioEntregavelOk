import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    List<Aluno> listaDeAlunos = new ArrayList<>();
    List<Professor> listaDeProfessores = new ArrayList<>();
    List<Curso> listaDeCursos = new ArrayList<>();
    List<Matricula> listaDeMatricula = new ArrayList<>();

    public void registrarCurso (String nome, Integer codigoCurso, Integer quantidadeMaximaDeAlunos){
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setCodigoDeCurso(codigoCurso);
        curso.setQtdMaximaDeAlunos(quantidadeMaximaDeAlunos);
        listaDeCursos.add(curso);
    }

    public void excluirCurso (Integer codigoCurso){
        for (Curso curso : listaDeCursos) {
            if (listaDeCursos.contains(curso.getCodigoDeCurso())){
                listaDeCursos.remove(curso);
            } else {
                System.out.println("Curso não encontrado");
            }
        }

    }

    public void registrarProfessorAdjunto (String nome, String sobrenome, Integer codigoProfessor, Integer quantidadeDeHoras){
        ProfessorAdjunto professorAdjunto = new ProfessorAdjunto();
        listaDeProfessores.add(professorAdjunto);
    }

    public void registrarProfessorTitular (String nome, String sobrenome, Integer codigoProfessor, String especialidade){
        ProfessorTitular professorTitular = new ProfessorTitular();
        listaDeProfessores.add(professorTitular);
    }

    public void excluirProfessor (Integer codigoProfessor){
        for (Professor professor : listaDeProfessores) {
            if (listaDeProfessores.contains(professor.getCodigoDeProfessor())){
                listaDeProfessores.remove(professor);
            } else {
                System.out.println("Professor não encontrado");
            }

        }

    }

    public void registrarAluno (String nome, String sobrenome, Integer codigoAluno){
        Aluno aluno = new Aluno(nome, sobrenome, codigoAluno);
        listaDeAlunos.add(aluno);

    }

    public Aluno getAlunoPorCodigo (Integer codigoDoAluno){
        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getCodigoDeAluno().equals(codigoDoAluno)){
                return aluno;
            }
        }return null;
    }

    public Curso getCursoPorCodigo (Integer codigoDoCurso){
        for (Curso curso : listaDeCursos) {
            if (curso.getCodigoDeCurso().equals(codigoDoCurso)){
                return curso;
            }

        }return null;

    }

    public void matricularAluno (Integer codigoAluno, Integer codigoCurso){

        Aluno alunoEncontrado = getAlunoPorCodigo(codigoAluno);
        Curso cursoEncontrado = getCursoPorCodigo(codigoCurso);

        if (cursoEncontrado.adcionarUmAluno(alunoEncontrado)){
            Matricula matricula = new Matricula(getAlunoPorCodigo(codigoAluno), getCursoPorCodigo(codigoCurso));
            listaDeMatricula.add(matricula);
            System.out.println("Matrícula no curso de " + cursoEncontrado.getNome() + " realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a matrícula no curso de " + cursoEncontrado.getNome() + ". Não há vagas.");

        }




    }

    public Professor getProfessorPorCodigo (Integer codigoProfessor){
        for (Professor professor : listaDeProfessores) {
            if (professor.getCodigoDeProfessor() == codigoProfessor){
                return professor;
            }

        }
        return null;


    }

    public void alocarProfessores (Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){

        ProfessorTitular professorTitular = (ProfessorTitular) getProfessorPorCodigo(codigoProfessorTitular);
        ProfessorAdjunto professorAdjunto = (ProfessorAdjunto) getProfessorPorCodigo(codigoProfessorAdjunto);

        getCursoPorCodigo(codigoCurso).setProfessorAdjunto(professorAdjunto);
        getCursoPorCodigo(codigoCurso).setProfessorTitular(professorTitular);


    }

    public Curso consultarMatricula(Integer codigoAluno){
        for (Matricula matricula : listaDeMatricula) {
            if (matricula.getAluno().getCodigoDeAluno().equals(codigoAluno)){
                return matricula.getCurso();
            }

        }return null;

    }

}
