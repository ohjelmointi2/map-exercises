# Map-harjoitukset

Tämän harjoitustehtäväpaketin myötä opit hyödyntämään Map-tietorakennetta omissa sovelluksissasi. Harjoitusten tueksi suosittelemme lukemaan Oraclen dev.java-tutoriaalista sivut [Using Maps to Store Key Value Pairs](https://dev.java/learn/api/collections-framework/maps/) sekä [Managing the Content of a Map](https://dev.java/learn/api/collections-framework/working-with-keys-and-values/).

> *"A hashmap is a structure able to store key-value pairs. The value is any object your application needs to handle, and a key is something that can represent this object.*
>
> *Suppose you need to create an application that has to handle invoices, represented by instances of an Invoice class. Then your values are these Invoice instances, and your keys could be the invoice numbers. Each invoice has a number, and that number is unique among all your invoices."*
>
> Using Maps to Store Key Value Pairs. Oracle. https://dev.java/learn/api/collections-framework/maps/

Tehtävä koostuu useammasta osasta, jotka arvioidaan erikseen hyödyntäen valmiiksi kirjoitettuja JUnit-testejä. Ennen oman toteutuksen aloittamista varmista, että saat suoritettua tehtäväpohjassa valmiina olevan koodin ongelmitta run-komennolla:

```sh
./gradlew run       # unix
gradlew.bat run     # windows
```

💡 Ensimmäisellä suorituskerralla suoritus saattaa olla hyvin hidas, mutta [suoritus nopeutuu seuraavilla kerroilla Gradlen välimuistin ansiosta](https://docs.gradle.org/current/userguide/build_cache.html). Voit myös vaihtoehtoisesti suorittaa ohjelmasi käyttämäsi koodieditorin "run"-painikkeella.


## Tehtävä 1: Map-tietorakenteen käyttäminen

Tässä tehtävässä harjoitellaan uuden `Map`-olion luontia sekä tyypillisimpiä operaatioita tiedon lisäämiseksi, hakemiseksi, muuttamiseksi ja poistamiseksi.

Tehtävässä koodattava Java-luokka [MapBasics](./src/main/java/part01/MapBasics.java) koostuu valmiista metodeista, joiden javadoc-kommentit kertovat, miten metodin tulisi toimia. **Sinun tehtäväsi on lukea kommentit ja toteuttaa metodin sisältö vastaamaan metodin nimeä sekä kuvausta.**

Voit testata koodiasi esimerkiksi oman `main`-metodin avulla, tai voit hyödyntää tehtävän valmiita JUnit-yksikkötestejä, jotka löytyvät [MapBasicsTest](./src/test/java/part01/MapBasicsTest.java)-luokasta. Voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```sh
./gradlew test --tests MapBasicsTest      # unix
gradlew.bat test --tests MapBasicsTest    # windows
```

💡 Sinun ei tarvitse perehtyä varsinaisen testin tekniseen toteutukseen. Tässä vaiheessa riittää, että suoritat testit ja tutustut niiden mahdollisesti tuottamiin virheilmoituksiin.

💡 Jos testi ei mene läpi, kokeile suorittaa komento uudestaan siten, että lisäät loppuun argumentin `--info`. Näin saat tarkemman tiedon siitä, mikä testissä meni pieleen. Voit myös avata HTML-muotoisen testiraportin, joka kertoo lisätietoja virheestä. Vaihtoehtoisesti voit suorittaa testit koodieditorisi testauspainikkeilla.

💡  Huomaa, että tämän luokan monet metodit eivät ole riippuvaisia käytettävän Map-tietorakenteen tyypistä. Esimerkiksi `countEntries`-metodi voisi toimia yhtä hyvin `<String, String>`- kuin `<String, Integer>`-tyyppisten avainten ja arvojen kanssa. Oikeassa ohjelmassa käyttäisit todennäköisesti geneerisiä tyyppejä, kuten `Map<K, V>`. Tehtävässä ei tarvitse erikseen perehtyä geneerisiin tyyppeihin, mutta voit halutessasi tutustua aiheeseen itsenäisesti ja toteuttaa metodit geneerisinä. Katso lisätietoja tutoriaalista: https://dev.java/learn/generics/.


## Tehtävä 1: väkiluvut

Tässä tehtävässä harjoitellaan uuden `Map`-olion luontia sekä tiedon lisäämistä, hakemista ja läpikäyntiä `Map`-tietorakenteen kanssa.

Tehtävässä sinun tulee täydentää seuraavaa tehtäväpohjaa `Exercise1.java`:

```java
import java.util.HashMap;
import java.util.Map;

public class Exercise1 {

    public Map<String, Long> buildPopulationMap() {
        // TODO: Luo uusi map, johon lisäät pohjoismaiden nimet ja väkiluvut
    }

    public void setPopulation(Map<String, Long> populations, String country, long population) {
        // TODO: Aseta annettuun Map-tietorakenteeseen annettu maa sekä sen väkiluku.
        // Mikäli maa löytyy jo Map:ista, korvataan sen aikaisempi väkiluku uudella.
    }

    public void incrementPopulation(Map<String, Long> populations, String country, long change) {
        // TODO: Kasvata annetussa Map-tietorakenteessa olevan maan väkilukua annetun määrän verran.
        // Mikäli maata ei löydy valmiiksi, asetetaan annettu muutos sellaisenaan väkiluvuksi.
    }

    public long sumOfPopulations(Map<String, Long> map) {
        // TODO: Laske yheen annetussa Map-tietorakenteessa olevien maiden väkiluvut ja palauta tulos
    }
}
```

`buildPopulationMap`-metodissa luotavan `Map`-tietorakenteen alkuarvoiksi tulee asettaa seuraavat maat ja niiden väkiluvut:

Maa     | Väkiluku
--------|-----------:
Denmark | 5 894 687
Finland | 5 587 442
Iceland | 354 234
Norway  | 5 509 591
Sweden  | 10 261 767

Väkilukujen lähde: [Wikipedia](https://en.wikipedia.org/wiki/Nordic_countries), 9.8.2023

## Tehtävä 2: etunimitilasto

Tässä tehtävässä opit:

* keräämään Map-tietorakenteeseen uutta informaatiota listalta lukemiesi tietojen perusteella
* muokkaamaan välilyönnillä esitettyjä lukuja int-tyypin edellyttämään muotoon
* lisäämään Map-tietorakenteeseen uusia arvoja
* tarkastamaan sisältääkö Map-tietorakenne arvoa tietyllä avaimella
* kasvattamaan Map-tietorakenteessa jo valmiiksi olevaa arvoa

Tässä tehtävässä sinun tulee hyödyntää Väestörekisterikeskuksen julkaisemaa ensimmäisten etunimien tilastoa ja kirjoittaa ohjelma, joka kertoo käyttäjälle kuinka monta kunkin nimistä Suomen kansalaista on väestötietojärjestelmässä.

Aineistossa kukin nimi, määrä ja henkilöiden sukupuoli on erotettu riveittän puolipisteillä seuraavalla tavalla:

```csv
Etunimi;Lukumäärä
Anne;30 204
Tuula;30 113
Päivi;29 789
Anna;28 677
Leena;27 745
```

Tietyllä merkillä erotellusta tekstitiedostosta käytetään yleisesti termiä [CSV (Comma Separated Values)](https://en.wikipedia.org/wiki/Comma-separated_values), vaikka erottimena tässä tapauksessa onkin käytetty puolipistettä (`;`).


### CSV-datan käsitteleminen

Aineistoa käsitellessäsi sinun tulee pilkkoa kukin rivi puolipisteiden kohdalta ja laittaa saamastasi taulukosta nimi sekä lukumäärää talteen map:iin. Huomaa, että tiedostossa lukumäärä on esitetty merkkijonona ja siinä käytetään tuhaterottimena välilyöntiä (esim. `"30 204"`). Joudut poistamaan välilyönnit merkkijonosta ennen sen muuttamista kokonaisluvuksi, esimerkiksi näin:

```java
String maara = osat[1];
maara = maara.replaceAll(" ", "");
```

Huomaa myös, että joitakin nimiä esiintyy sekä miehillä ja naisilla, jolloin sinun tulee tarpeen mukaan kasvattaa kokoelmaan tallennettua arvoa sen ylikirjoittamisen sijaan.


## Käyttöliittymä

Kun aineisto on käyty läpi, ohjelmasi tulee kysyä käyttäjältä nimiä ja kertoa, kuinka monta annetun nimistä suomalaista aineistosta löytyy. Katso tarkempi kuvaus alta esimerkkisuorituksesta. Ohjelman suoritus päättyy, kun käyttäjä syöttää tekstin "exit" tai jättää nimen tyhjäksi.

```
First name: Pekka
33630

First name: Pirkko
24786

First name: Kaino
916

First name: Tuisku
196

First name: Lahja
2647

First name: Wolverine
0

First name: exit

Bye!
```

## Nimiaineiston lisenssi

[Digi- ja väestötietovirasto (DVV)](https://www.avoindata.fi/data/fi/organization/digi_ja_vaestotietovirasto) on julkaissut tietoaineiston [Väestötietojärjestelmän suomalaisten nimiaineistot](https://www.avoindata.fi/data/fi/dataset/none) lisenssillä [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/):

* [etunimitilasto-miehet-ensimmainen.csv](/data/etunimitilasto-miehet-ensimmainen.csv)
* [etunimitilasto-miehet-muut.csv](/data/etunimitilasto-miehet-muut.csv)
* [etunimitilasto-naiset-ensimmainen.csv](/data/etunimitilasto-naiset-ensimmainen.csv)
* [etunimitilasto-naiset-muut.csv](/data/etunimitilasto-naiset-muut.csv)
* [sukunimitilasto.csv](/data/sukunimitilasto.csv)

### Postinumeroaineiston tekijänoikeudet

Tässä projektissa hyödynnettävä postinumeroaineisto [postcode_map_light.json](postcode_map_light.json) on lainattu [https://github.com/theikkila/postinumerot](https://github.com/theikkila/postinumerot)-projektin [postcode_map_light.json](https://github.com/theikkila/postinumerot/blob/master/postcode_map_light.json)-tiedostosta 7.6.2023.

Datan tekijänoikeudet kuuluvat Postille ja niitä käytetään [Postin käyttöehtojen mukaisesti](https://www.posti.fi/fi/asiakastuki/postinumerotiedostot). Mikäli teet kopioita tästä aineistosta, huolehdi käyttöehtojen noudattamisesta.

* [postcode_map_light.json](/data/postcode_map_light.json)
