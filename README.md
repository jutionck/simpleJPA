### Spring JPA

Langkah-langhkah pembuatan
1. Silahkan clone aplikasi ini jika tidak ingin membuat dari awal
2. Siapkan terlebih dahulu database, disini kita memakai database MySQL
3. Konfigurasi environment nya adalah sebagai berikut :
    ```
   DB_HOST=localhost;DB_PORT=3306;DB_SCHEMA=db_mandiri;DB_USER=root;DB_PASSWORD=password
   ```
4. Untuk menjalankan aplikasi ketikkan perintah ini:
    ```
   DB_HOST=localhost DB_PORT=3306 DB_SCHEMA=db_mandiri DB_USER=root DB_PASSWORD=password mvn spring-boot:run
   ```

Jika kalian memakai IDE dari Intellij IDEA, silahkan ikuti beberapa langkah ini :
1. Klik menu **Run** kemudian pilih **Edit Konfigurasi**
2. Tambahkan, dengan mengklik **+** lalu pilih **Maven**
3. Unceklis **Use Project Setting** pada bagian **Runner** lalu tambahkan environment seperti ini: <br>
    | Name  | Value |
    | ------------- | ------------- |
    | DB_HOST  | localhost  |
    | DB_PORT  | 3306  |
    | DB_SCHEMA  | db_mandiri  |
    | DB_USER  | root  |
    | DB_PASSWORD  | password  |
4. Pada bagian **Parameter** tambahkan command line :
   ```
    spring-boot:run
    ```
5. Selesai, silahkan klik tanda segitiga hijau untuk menjalankan project    

