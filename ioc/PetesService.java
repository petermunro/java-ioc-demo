package ioc;

public class PetesService implements Service {
    @Override
    public void doService() {
        System.out.println("PetesService doService()");
    }
}
