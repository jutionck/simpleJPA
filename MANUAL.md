### Manual Book

Spring Framework merupakan salah satu dari framework di Java. 
Sebelum masuk ke spring kita berkenalan dulu apa sih dasar yang mendukung kita memakai spring framework.
Pada spring framework terdapat dua istilah yang penting yaitu **Ioc (Inversion of Control)** dan **Dependency Injection**

**Inversion of Control** adalah sebuah pembalik kendali sebuah object, pembalik kendali itu sendiri apa? Sebuah kendali object yang semula di lakukan di program, di pindahkan kedalam sebuah framework atau container.
Kita berikan sebuah contoh langsung pada code program:
```
public class Animal {
    public String name;
    public int Age;

    public function eat() {
        System.out.println("Hewan ini bisa makan...");   
    }
}
```
```
public class App {
    public static void main(String[] args) {
        //Inisialisasi object Animal
        Animal animal = new Animal();
        animal.name = "Kucing";
        animal.age = 20;
        animal.eat();
    }
}
```
Kode diatas adalah contoh code sederhana dalam membuat object dari class **Animal**.
Dengan menggunakan **Ioc** hal seperti itu tidak demikian, namun perlu di ingat dalam beberapa kasus pembuatan object seperti 
```
Animal animal = new Animal()
```
Masih bisa di temukan dalam pembuatan project spring.

Tadi kita sempat membahasa **Container**, apa sih container itu, container adalah komponen terpusat yang ada di spring framework yang berguna untuk menampung semua komponen object (kemudian disebut spring bean) dan menangani daur hidup secara keseluruhan.

Untuk mengenali masing – masing beans yang ada di dalam Container, Spring menggunakan konfigurasi metadata yang dapat direpresentasikan dalam format XML atau dalam bentuk anotasi java. Hal ini mirip dengan Apache Tomcat yang merupakan servlet container, juga membaca web.xml  untuk mengidentifikasi servlet mana yang akan dibentuk.

**Dependency Injection** adalah sebuah design pattern di dalam software engineering modern yang sangat penting untuk memudahkan sebuah program untuk dibuat unit-testing, kebalikan dari **DI** adalah hardcoded dependencies.

Dalam banyak referensi juga disebutkan bahwa DI adalah salah satu implementasi dari IoC, atau bagaimana teknis dari konsep IoC diterapkan.

Sehingga pada code di atas kita dapat membuat nya menjadi :
```
public class App {
    private Animal animal;
    public App(Animal animal) {
        this.animal = animal;
    }
}
```

