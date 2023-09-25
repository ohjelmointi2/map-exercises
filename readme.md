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


## Tehtävä 1: Map-tietorakenteen käyttäminen (perusteet, X % pisteistä)

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


## Tehtävä 2: etunimitilasto (soveltaminen, X % pisteistä)

Tässä tehtävässä sinun tulee hyödyntää [Väestörekisterikeskuksen julkaisemaa ensimmäisten etunimien tilastoa](https://www.avoindata.fi/data/fi/dataset/none) ja kirjoittaa ohjelma, joka kertoo käyttäjälle kuinka monta kunkin nimistä Suomen kansalaista on väestötietojärjestelmässä.

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

## Tehtävä 3: postinumerot  (soveltaminen, X % pisteistä)

Tietokoneohjelmat käyttävät usein JSON-tiedostomuotoa rakenteellisen datan käsittelyssä. JSON (JavaScript Object Notation) on kevyt ja yleinen tapa tallentaa ja siirtää tietoa ohjelmien välillä. JSON-muotoista dataa voidaan käyttää monissa erilaisissa sovelluksissa, kuten verkkopalvelimissa, mobiilisovelluksissa ja tietokantojen kanssa työskennellessä. JSON-muotoinen data voi näyttää esim. seuraavalta:

```json
{
    "74701": "KIURUVESI",
    "35540": "JUUPAJOKI",
    "74705": "PAKETTIAUTOMAATTI",
    "74704": "SMARTPOST",
    "44884": "SMART POST"
}
```

Java-ohjelmassa Map-tietorakenne soveltuu erinomaisesti yllä esitettyjen avain-arvo-parien käsittelemiseen. Tässä tehtävässä keskitymme postinumeroaineiston käsittelyyn, joka on tallennettu [JSON-muotoiseen tiedostoon](./data/postcode_map_light.json).

JSON-tiedoston lukemiseen Java-ohjelmassa käytämme Googlen julkaisemaa [GSON-kirjastoa](https://github.com/google/gson). GSON mahdollistaa JSON-datan muuntamisen Java-olioiksi ja päinvastoin. Se tarjoaa helpon tavan käsittää JSON-tietoa ilman monimutkaisia manuaalisia toimenpiteitä. GSON-kirjaston käyttö on sinulle valmiiksi annettuna luokassa [PostalCodes](./src/main/java/part03/PostalCodes.java). Sinun ei tarvitse perehtyä GSONin yksityiskohtiin tai implementoida sitä itse.

Sinun tehtäväsi on luoda [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java)-luokkaan logiikka, joka etsii luetusta Map-tietorakenteesta käyttäjän syöttämää postinumeroa vastaavan postitoimipaikan nimen tai nimeä vastaavat postinumerot.

Käyttäjä saattaa siis antaa parametrina numeron, jolloin ohjelma etsii sitä vastaavan toimipaikan nimen:

```
Mitä etsitään? 00100

Toimipaikka: Helsinki
```

Mikäli postinumeroa ei löydy aineistosta, tulosta teksti "Postinumeroa ei löytynyt."

Jos käyttäjä syöttää toimipaikan nimen, ohjelman tulee tulostaa kaikki postinumerot, jotka kuuluvat kyseiseen postitoimipaikkaan:

```
Mitä etsitään? Porvoo

Postinumerot: 06100, 06101, 06150, 06151, 06200, 06400, 06401, 06450, 06500
```

Toisin kuin edellisessä tehtävässä, tässä ongelmaa ei voida ratkaista tarkistamalla arvoa suoraan yksittäisen avaimen avulla. Sen sijaan sinun tulee käydä koko Map-tietorakenne läpi ja etsiä kaikki postinumerot, eli avaimet, joiden arvo vastaa käyttäjän antamaa merkkijonoa. Mikäli annetulle nimelle ei löydy lainkaan postinumeroita, tulosta "Postinumeroita ei löytynyt."

Tulosteessa postinumeroiden tulee olla kasvavassa järjestyksessä pilkuilla eroteltuna, joten kerää postinumerot ensin esimerkiksi listalle, jonka järjestät ennen tulostamista.



## Nimiaineiston lisenssi

[Digi- ja väestötietovirasto (DVV)](https://www.avoindata.fi/data/fi/organization/digi_ja_vaestotietovirasto) on julkaissut tietoaineiston [Väestötietojärjestelmän suomalaisten nimiaineistot](https://www.avoindata.fi/data/fi/dataset/none) lisenssillä [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/):

* [etunimitilasto-miehet-ensimmainen.csv](/data/etunimitilasto-miehet-ensimmainen.csv)
* [etunimitilasto-miehet-muut.csv](/data/etunimitilasto-miehet-muut.csv)
* [etunimitilasto-naiset-ensimmainen.csv](/data/etunimitilasto-naiset-ensimmainen.csv)
* [etunimitilasto-naiset-muut.csv](/data/etunimitilasto-naiset-muut.csv)
* [sukunimitilasto.csv](/data/sukunimitilasto.csv)

## Postinumeroaineiston tekijänoikeudet

Tässä projektissa hyödynnettävä postinumeroaineisto [postcode_map_light.json](./data/postcode_map_light.json) on lainattu [https://github.com/theikkila/postinumerot](https://github.com/theikkila/postinumerot)-projektin [postcode_map_light.json](https://github.com/theikkila/postinumerot/blob/master/postcode_map_light.json)-tiedostosta 7.6.2023.

Datan tekijänoikeudet kuuluvat Postille ja niitä käytetään [Postin käyttöehtojen mukaisesti](https://www.posti.fi/fi/asiakastuki/postinumerotiedostot). Mikäli teet kopioita tästä aineistosta, huolehdi käyttöehtojen noudattamisesta.

* [postcode_map_light.json](./data/postcode_map_light.json)


## Tehtävän tekijänoikeudet

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. Tehtävän luonnissa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub Copilot -tekoälytyökalua.
