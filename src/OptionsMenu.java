public class OptionsMenu {
    public static void printMenu() {
        try {
            Thread.sleep(1000); // Pause for the specified number of milliseconds
        } catch (InterruptedException e) {
            // Handle the InterruptedException, which can occur if another thread interrupts the current thread while it's sleeping.
            e.printStackTrace();
        }
        System.out.println("----------------------------------------");
        System.out.println("Escolha e digite:");
        System.out.println("- 1: Reservar lugar;");
        System.out.println("- 2: Exibir mapa de reservas;");
        System.out.println("- 3: Encerrar programa.");
    }
}
