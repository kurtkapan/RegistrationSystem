import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements IKayit {
    private List<Musteri> musteriler = new ArrayList<>();
    private List<Film> filmler = new ArrayList<>();
    private List<Salon> salonlar = new ArrayList<>();

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n1. Yeni Müşteri Ekle");
            System.out.println("2. Yeni Film Ekle");
            System.out.println("3. Yeni Salon Ekle");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Salonlardaki Müşterileri Listele");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1 -> musteriEkle();
                case 2 -> filmEkle();
                case 3 -> salonEkle();
                case 4 -> filmListele();
                case 5 -> salonMusteriListele();
                case 6 -> System.out.println("Çıkış yapılıyor...");
                default -> System.out.println("Geçersiz seçim!");
            }
        } while (secim != 6);

        scanner.close();
    }

    @Override
    public void kayitEkle() {
        System.out.println("Bu sistem genel kayıtlara özel yöntemlere sahiptir.");
    }

    @Override
    public void kayitListele() {
        System.out.println("Genel listeleme işlemi yapılmamaktadır.");
    }

    private void musteriEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Müşteri ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Müşteri Adı: ");
        String ad = scanner.nextLine();
        Musteri musteri = new Musteri(id, ad);
        musteriler.add(musteri);
        System.out.println("Müşteri başarıyla eklendi.");
    }

    private void filmEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Film Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Film Süresi (dk): ");
        int sure = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Film Türü: ");
        String tur = scanner.nextLine();
        Film film = new Film(ad, sure, tur);
        filmler.add(film);
        System.out.println("Film başarıyla eklendi.");
    }

    private void salonEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salon ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Salon Adı: ");
        String ad = scanner.nextLine();
        Salon salon = new Salon(id, ad);

        System.out.println("Gösterimde olacak film seçin:");
        for (int i = 0; i < filmler.size(); i++) {
            System.out.println((i + 1) + ". " + filmler.get(i).getAd());
        }
        int filmSecim = scanner.nextInt() - 1;
        salon.setFilm(filmler.get(filmSecim));

        salonlar.add(salon);
        System.out.println("Salon başarıyla eklendi.");
    }

    private void filmListele() {
        for (Film film : filmler) {
            film.bilgiGoster();
        }
    }

    private void salonMusteriListele() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Salonları seçin:");
        for (int i = 0; i < salonlar.size(); i++) {
            System.out.println((i + 1) + ". " + salonlar.get(i).getName());
        }
        int salonSecim = scanner.nextInt() - 1;

        Salon salon = salonlar.get(salonSecim);
        System.out.println(salon.getName() + " salonundaki müşteriler:");
        for (Musteri musteri : salon.getMusteriler()) {
            musteri.bilgiGoster();
        }
    }
}
