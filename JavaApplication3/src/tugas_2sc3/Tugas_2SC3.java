/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_2sc3;

public class Tugas_2SC3 {
int bulan,tanggal;
    public static void main(String[] args) {
        Tugas_2SC3 tt = new Tugas_2SC3();
        tt.bulanTanggal();
    }
    public void bulanTanggal(){
        if((tanggal >= 21 && bulan==3) || (tanggal<=19 && bulan==4 )){
   System.out.print("Zodiak Anda : Aries");
  }else if((tanggal >=20 && bulan == 4) || (tanggal <=20 && bulan == 5)){
   System.out.print("Zodiak anda Taurus");
  }else if((tanggal >=21 && bulan == 5) || (tanggal <=20 && bulan == 6)){
   System.out.print("Zodiak anda Gemini");
  }else if((tanggal >=21 && bulan == 6) || (tanggal <=22 && bulan == 7)){
   System.out.print("Zodiak anda Cancer");
  }else if((tanggal >=23 && bulan == 7) || (tanggal <=22 && bulan == 8)){
   System.out.print("Zodiak anda Leo");    
  }else if((tanggal >=23 && bulan == 8) || (tanggal <=22 && bulan == 9)){
   System.out.print("Zodiak anda Virgo");    
  }else if((tanggal >=23 && bulan == 9) || (tanggal <=22 && bulan == 10)){
   System.out.print("Zodiak anda Libra");    
  }else if((tanggal >=23 && bulan == 10) || (tanggal <=21 && bulan == 11)){
   System.out.print("Zodiak anda Scorpio");    
  }else if((tanggal >=22 && bulan == 11) || (tanggal <=21 && bulan == 12)){
   System.out.print("Zodiak anda Sagitarius");    
  }else if((tanggal >=22 && bulan == 12) || (tanggal <=19 && bulan == 1)){
   System.out.print("Zodiak anda Capricorn");    
  }else if((tanggal >=20 && bulan == 1) || (tanggal <=18 && bulan == 2)){
   System.out.print("Zodiak anda Aquarius");    
  }else if((tanggal >=19 && bulan == 2) || (tanggal <=20 && bulan == 3)){
   System.out.print("Zodiak anda Pisces");    
  }
    }
    
}
