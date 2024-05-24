#include <iostream>
using namespace std;
class Complex {
private:
 double real;
 double imaginary;
public:
 Complex() : real(0.0), imaginary(0.0) {}
 Complex(double r, double i) : real(r), imaginary(i) {}
 friend Complex operator+(const Complex& c1, const Complex& c2);
 friend Complex operator-(const Complex& c1, const Complex& c2);
 Complex multiply(const Complex& other) const;
 Complex divide(const Complex& other) const;
 void display() const {
 cout << "Result: " << real << " + " << imaginary << "i" << endl;
 }
};
Complex operator+(const Complex& c1, const Complex& c2) {
 return Complex(c1.real + c2.real, c1.imaginary + c2.imaginary);
}
Complex operator-(const Complex& c1, const Complex& c2) {
 return Complex(c1.real - c2.real, c1.imaginary - c2.imaginary);
}
Complex Complex::multiply(const Complex& other) const {
 return Complex((real * other.real) - (imaginary * other.imaginary),
 (real * other.imaginary) + (imaginary *
other.real));
}
Complex Complex::divide(const Complex& other) const {
 double denominator = (other.real * other.real) + (other.imaginary *
other.imaginary);
 return Complex(((real * other.real) + (imaginary *
other.imaginary)) / denominator,
 ((imaginary * other.real) - (real *
other.imaginary)) / denominator);
}
int main() {
 Complex c1(2.0, 3.0);
 Complex c2(1.0, 2.0);
 Complex result_add = c1 + c2;
 Complex result_sub = c1 - c2;
 result_add.display();
 result_sub.display();
 Complex result_mul = c1.multiply(c2);
 Complex result_div = c1.divide(c2);
 result_mul.display();
 result_div.display();
 return 0;
}

