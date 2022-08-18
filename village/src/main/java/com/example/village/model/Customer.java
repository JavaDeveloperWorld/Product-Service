package com.example.village.model;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class Customer {
        private int id;
        private String name;
        private String surname;
        private String  age;
        private String phone;
        private String address;
        private String email;
        private String gender;
        private String photo;
        private String password;
        private String confirmPassword;
        private int status;

        public Customer(){
        }

        public Customer(int id,String name, String surname, String  age,String phone,String address, String email, String gender,String photo,String password,String confirmPassword,int status) {
            this.id=id;
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.phone=phone;
            this.address=address;
            this.email = email;
            this.gender = gender;
            this.photo=photo;
            this.password=password;
            this.confirmPassword=confirmPassword;
            this.status=status;

        }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String  getAge() {
            return age;
        }

        public void setAge(String  age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age='" + age + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", email='" + email + '\'' +
                    ", gender='" + gender + '\'' +
                    ", photo='" + photo + '\'' +
                    ", password='" + password + '\'' +
                    ", confirmPassword='" + confirmPassword + '\'' +
                    '}';
        }
}
