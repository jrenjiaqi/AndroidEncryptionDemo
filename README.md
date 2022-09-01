# Android Encryption Demonstration
<p align="center">
  <img width="250" alt="homepage" src="https://user-images.githubusercontent.com/98270848/187900674-cadfd67c-d4eb-4bd2-b5b0-59ac70ee96a5.png">
</p>

## 1. Environment and Language
- Developed with: **Android Studio in Linux**
  - via Windows Subsystem for Linux, Ubuntu, and VcXSrv

- Written in: **Java**

## 2. Project Objectives

Encryption Demonstration:
- Message Digest (MD5) + Salt
- Advanced Encryption Standard (AES)

Android Demonstration:
- Android Development in Linux (WSL2, Ubuntu, VcXSrv)
- Android Unit Testing (JUnit)
- Android Instrumented Testing (Espresso)

## 3. Project Summary

### 3.1 MD5 + Salt >> One-way Encryption >> Password Hashing and Authentication

- User enters password (simulates registration process).
- User enters password again (simulates logging in).
- Upon 'encrypt and match' button click, hashed passwords are compared instead of plain text password.
<p align="center">
<img width="501" alt="one-way-combined" src="https://user-images.githubusercontent.com/98270848/187902429-cbdaf89b-3cae-4619-9c3b-2634c17d7e71.png">
</p>

### 3.2 AES >> Two-way En/Decryption >> Plain Text to Cipher Text (vice versa)

- User enters plain text and presses 'encrypt text' button.
- AES encrypted cipher text is generated.
- User presses 'decrypt text' button.
- Plain text is decrypted from cipher text.
<p align="center">
<img width="275" alt="two-way-encryption" src="https://user-images.githubusercontent.com/98270848/187905899-cf4992d8-1b54-4849-906a-7a7abb8dbc34.png">
</p>

### 3.3 Android Development in Linux

- Windows Subsystem for Linux (WSL2) allows for Linux (Ubuntu) use without dual-booting.
- VcXSrv provides an environment to use Android Studio in Linux.
- Simple setup required as per [link](https://autoize.com/xfce4-desktop-environment-and-x-server-for-ubuntu-on-wsl-2/).
<img width="1280" alt="desktop-setup" src="https://user-images.githubusercontent.com/98270848/187907697-9757f617-e982-4456-9ea5-5ee8f0025407.png">

### 3.4 Android Unit Tests

- JUnit Assertions 
- MD5 Working and Salt Non-Collision Test
- AES Encryption-then-Decryption Returns Original Plain Text Test

### 3.5 Android Instrumented Tests
- Ensure One-way Encryption behaves as expected on Android.
<img width="866" alt="one-way-encryption-ss" src="https://user-images.githubusercontent.com/98270848/187909682-e50480bd-6937-4791-adb8-4b6da4a02ae2.png">

- Ensures Two-way En/Decryption behaves as expected on Android.
<img width="859" alt="two-way-encryption-ss" src="https://user-images.githubusercontent.com/98270848/187909732-c156eb87-9d1b-4228-b39b-c925c3c317a5.png">
<img width="414" alt="two-way-encryption-ss-pt2" src="https://user-images.githubusercontent.com/98270848/187909778-d5e5b56c-5387-4da9-bc27-8854ff3c25bb.png">

