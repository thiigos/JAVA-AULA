public class SistemaDeAutentificação {

    public void login(Autenticavel funcionario, String senha){
        if (funcionario.autenticar(senha)){
            System.out.println("\nAutentificação bem-sucedida!");
        } else {
            System.out.println("\nFalha na autentificação!");
        }
    }
}
