Projekt klienta HobbyHunter. Jest to projekt do Android Studio.

Jako, że nie ma serwera w sieci, przed kompilacją należy ustawić IP serwera (port domyślny to 8080):

  1. Jeśli klient jest uruchcamiany na emualtorze na komputerze na którym działa serwer, i emulatorem jest...
    a. AVD (domyślny w Android Studio) - 10.0.2.2 lub lokalny adres komputera
    b. Genymotion - 10.0.2.3 lub lokalny adres komputera
  2. Jeśli klient jest uruchamiany na telefonie...
    a. i serwer jest w sieci lokalnej do której telefon jest podłączony przez WiFi - adres lokalny komputera
    b. i serwer posiada adres zewnętrzny - adres zewnętrzny serwera
    
Można też kombinować z routingiem jeśli komuś się chce.
