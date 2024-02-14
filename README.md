# tutorial-1

Nama: Emir Mohamad Fathan
NPM: 2206081982

# Refleksi 1

Pada exercise 1 kali ini saya mengimplementasikan clean code pada kode saya. Praktek clean code yang saya implementasikan adalah seperti meaningful names, dimana nama-nama variabel pada kode sudah mendeskripsikan apa fungsi variabel tersebut. Lalu function-function pada kode tidak terlalu panjang contohnya pada create product ada fungsi yang saling memanggil antara class-class. Selain itu, saya juga menerapkan secure coding dimana saya menggunakan method POST pada delete, submit, dan edit product.

# Refleksi 2

1. Dengan adanya unit test saya bisa memastikan bahwa kode yang saya buat sudah aman dan bisa dipakai oleh end user. Sebaiknya, unit test harus minimal mencakup semua function yang ada di kode kita, juga harus memasukkan positive and negative scenarios. Pendapat saya, kode dengan code coverage 100% mungkin tidak memiliki bug atau error, namun untuk mencapai 100% code coverage itu sulit. Maka dari itu, 70-90% code coverage sudah cukup baik.

2. Sebaiknya, jika ingin membuat functional test baru, buatlah java class yang tidak tergantung kepada functional test yang sudah ada. Hal ini untuk menghindari kesamaan nama variabel yang dapat membawa error.

<hr>
<hr>

# Tutorial-2

# Refleksi

1. Saat saya melakukan tutorial kali ini saya menemukan beberapa kekurangan pada kode saya yaitu:

- Code coverage saya rendah yang mana jadi saya harus menambahkan unit test tambahan agar code coverage dapat mencapai angka yang lebih baik.
- Saat me-commit workflows CI, terdapat error yaitu permission denied pada github actions. Saat dipelajari, ternyata harus menambahkan permission dulu di workfloaws-nya yaitu dengan menambahkan chmod +x pada gradlew
- Saat berhasil deploy ke PaaS koyeb, web-app ternyata mengalami error yaitu "Whitelabel Error Page". Cara fix-nya adalah mengganti huruf kapital pada return di controller, karena ini merupakan case sensitive.

2. Menurut saya, implementasi workflows saya sudah cukup memenuhi definisi CI/CD. Karena saat saya push version baru pada repository github, github actions langsung otomatis menjalankan workflows yang sudah saya beri. Ini merupakan salah satu manfaat process automation. Selain itu, tiap saya melakukan commit lalu push atau pull request, sonarcloud dan juga PaaS koyeb langsung menjalankan automation pada kode saya.
