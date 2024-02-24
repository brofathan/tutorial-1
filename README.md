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

deployment: https://conventional-carola-eshop-tutorial-1.koyeb.app/

# Refleksi

1. Saat saya melakukan tutorial kali ini saya menemukan beberapa kekurangan pada kode saya yaitu:

- Code coverage saya rendah yang mana jadi saya harus menambahkan unit test tambahan agar code coverage dapat mencapai angka yang lebih baik.
- Saat me-commit workflows CI, terdapat error yaitu permission denied pada github actions. Saat dipelajari, ternyata harus menambahkan permission dulu di workfloaws-nya yaitu dengan menambahkan chmod +x pada gradlew
- Saat berhasil deploy ke PaaS koyeb, web-app ternyata mengalami error yaitu "Whitelabel Error Page". Cara fix-nya adalah mengganti huruf kapital pada return di controller, karena ini merupakan case sensitive.

2. Menurut saya, implementasi workflows saya sudah cukup memenuhi definisi CI/CD. Karena saat saya push version baru pada repository github, github actions langsung otomatis menjalankan workflows yang sudah saya beri. Ini merupakan salah satu manfaat process automation. Selain itu, tiap saya melakukan commit lalu push atau pull request, sonarcloud dan juga PaaS koyeb langsung menjalankan automation pada kode saya.

<hr>
<hr>

# Tutorial-3

# Refleksi

Pada exercise kali ini, saya mengimplementasikan prinsip SOLID pada kode saya. Adapun prinsip-prinsip pada SOLID serta penerapannya pada kode saya adalah:

- Single Responsibility Principle

Pada dasarnya, SPR adalah dimana setiap class hanya bertanggung jawab untuk beberapa method tertentu. Jika ada method yang tidak terlalu berkorelasi dengan classnya, akan dipisah kepada class baru. 
Saya mengimplementasikan SPR pada kode saya yaitu pada bagian package controller. Dimana sebelumnya class CarController dan ProductController digabung menjadi dipisah agar masing-masing method pada class terenkapsulasi pada satu file.

- Open-Closed Principle

OCP adalah dimana entitas atau komponen pada kode kita terbuka untuk ekstensi atau pengembangan namun tertutup pada modifikasi. Jika kita memiliki sebuah class, alih-alih kita memodifikasi class tersebut. Kode saya menerapkan prinsip ini yaitu pada package controller dimana adanya class CarController yang extends ProductController.

- Liskov Substitution Principle

LSP adalah dimana subclass me-replace atau mengimplementasikan kode yang ada pada parent class nya. Saya menggunakan prinsip ini pada package service dimana adanya interface CarService atau ProductService dan diimplementasikan pada class CarServiceImpl atau ProductServiceImpl.

- Interface Segregation Principle

ISP adalah dimana komponen kode yang besar dibagi-bagi menjadi komponen yang lebih kecil. Pada kode saya, implementasi ISP ini ada pada CarService atau ProductService.

- Dependency Inversions Principle

DIP adalah dimana modul yang lebih tinggi tidak bergantung kepada modul yang lebih rendah. Dalam artian, modul yang lebih rendah harus bergantung pada modul yang lebih tinggi. Saya mengimplementasikan DIP pada class CarServiceImpl atau ProductServiceImpl yang bergantung pada parent classnya.

Advantages menggunakan SOLID principles:
- Prinsip SOLID ini jelas menguntungkan kita dalam segi maintainability dimana saat kita ingin melakukan maintenance pada kode kita, kita mudahdalam melakukannya dan dapat meminimalkan error dalam prosesnya. Selain itu juga dari segi scalability dimana pada proses pengembangan kode, kode kita akan lebih fleksibel dan mudah untuk ditambahkan fitur-fitur baru.

Disadvantages tidak menggunakan SOLID principles:
- Kode akan sulit dikelola dalam proses pengembangan.
- Kode akan sulit dibaca oleh orang lain juga diri sendiri.
