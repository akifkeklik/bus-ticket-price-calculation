import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Mesafeyi km türünden giriniz: ");
            int km = input.nextInt();
            if (km <= 0) throw new Exception("Mesafe 0 veya negatif olamaz!");  // km geçersizse hata fırlat

            System.out.println("Yaşınızı girin: ");
            int age = input.nextInt();
            if (age <= 0) throw new Exception("Yaş 0 veya negatif olamaz!"); // yaş geçersizse hata fırlat


            System.out.println("Yolculuk tipini giriniz (1 -> Tek Yön , 2 -> Gidiş Dönüş): ");
            int tripType = input.nextInt();
            if (tripType != 1 && tripType != 2) throw new Exception("Yolculuk tipi sadece 1 veya 2 olabilir!"); // tip geçersizse hata fırlat


            double ticketPrice = km * 0.20;

            double ageDiscount = 0;        // varsayılan
            double ageDiscountRate = 0;

            double tripDiscount = 0;       // varsayılan
            double tripDiscountRate = 0;

            if (age < 12) {
                ageDiscountRate = 0.50;
            } else if (age <= 24) {
                ageDiscountRate = 0.10;
            } else if (age > 65) {
                ageDiscountRate = 0.30;
            }
            ticketPrice -= ticketPrice * ageDiscountRate; // yaş indirimi uygula

            /*
            ageDiscount = ticketPrice * ageDiscountRate;          // uygulanan yaş indirimi tutarı
            ticketPrice = ticketPrice - ageDiscount;             // yaş indirimli bilet fiyatı
            */

            if (tripType == 2) {
                tripDiscountRate = 0.10;
            }
            ticketPrice *= 2;                              // Gidiş - Dönüş olduğundan * 2 yaptık.
            ticketPrice -= ticketPrice * tripDiscountRate; // yolculuk indirimi uygula (indirim miktarını hesapla ve bilet fiyatından düş!)

            /*
            tripDiscount = ticketPrice * tripDiscountRate;       // uygulanan seyahat indirim tutarı
            ticketPrice = ticketPrice - tripDiscount;           // seyahat ve yas indirimi uygulanmış net bilet fiyatı
            */


            if (tripType == 1) {
                System.out.println("Bilet ücretiniz " + ticketPrice + " TL'dir.");
            } else {
                System.out.println("Gidiş-Dönüş bilet ücretiniz " + ticketPrice + " TL'dir.");
            }


        }catch(InputMismatchException e) {         // Kullanıcı sayı yerine harf gibi yanlış tip girerse
            System.out.println("Hatalı tip girdiniz! Lütfen sadece sayı girin.");
        } catch(Exception e){
            System.out.println("Hata: " + e.getMessage());
        }


    }
}