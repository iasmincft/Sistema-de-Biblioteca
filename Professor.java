public class Professor extends Usuario {
    
    public Professor(int id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean podeEmprestar() {
        return true;
    }
    
}
