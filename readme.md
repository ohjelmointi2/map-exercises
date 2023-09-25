# Map-harjoitukset

Tämän harjoitustehtäväpaketin myötä opit hyödyntämään Map-tietorakennetta omissa sovelluksissasi. Harjoitusten tueksi suosittelemme lukemaan Oraclen dev.java-tutoriaalista sivut [Using Maps to Store Key Value Pairs](https://dev.java/learn/api/collections-framework/maps/) sekä [Managing the Content of a Map](https://dev.java/learn/api/collections-framework/working-with-keys-and-values/).

> *"A hashmap is a structure able to store key-value pairs. The value is any object your application needs to handle, and a key is something that can represent this object.*
>
> *Suppose you need to create an application that has to handle invoices, represented by instances of an Invoice class. Then your values are these Invoice instances, and your keys could be the invoice numbers. Each invoice has a number, and that number is unique among all your invoices."*
>
> Using Maps to Store Key Value Pairs. Oracle. https://dev.java/learn/api/collections-framework/maps/

Tehtävä koostuu useammasta osasta, jotka arvioidaan erikseen hyödyntäen valmiiksi kirjoitettuja testejä.
Ennen oman toteutuksen aloittamista varmista, että saat suoritettua tehtäväpohjassa valmiina olevan koodin ongelmitta run-komennolla:


## Tehtävä 1: [MapBasics.java](./src/main/java/part01/MapBasics.java) (perusteet, 40 % pisteistä)

Tässä tehtävässä harjoittelemme uuden `Map`-olion luontia sekä tyypillisimpiä operaatioita tiedon lisäämiseksi, hakemiseksi, muuttamiseksi ja poistamiseksi.

Tehtävässä koodattava Java-luokka [MapBasics](./src/main/java/part01/MapBasics.java) koostuu valmiista metodeista, joiden javadoc-kommentit kertovat, miten metodin tulisi toimia. **Sinun tehtäväsi on lukea kommentit ja toteuttaa metodin sisältö vastaamaan metodin nimeä sekä kuvausta.**

Voit testata koodiasi esimerkiksi oman `main`-metodin avulla, tai voit hyödyntää tehtävän valmiita JUnit-yksikkötestejä, jotka löytyvät [MapBasicsTest](./src/test/java/part01/MapBasicsTest.java)-luokasta. Voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```sh
./gradlew test --tests MapBasicsTest      # unix
gradlew.bat test --tests MapBasicsTest    # windows
```

💡 Sinun ei tarvitse perehtyä varsinaisen testin tekniseen toteutukseen. Tässä vaiheessa riittää, että suoritat testit ja tutustut niiden mahdollisesti tuottamiin virheilmoituksiin.

💡 Jos testi ei mene läpi, kokeile suorittaa komento uudestaan siten, että lisäät loppuun argumentin `--info`. Näin saat tarkemman tiedon siitä, mikä testissä meni pieleen. Voit myös avata HTML-muotoisen testiraportin, joka kertoo lisätietoja virheestä. Vaihtoehtoisesti voit suorittaa testit koodieditorisi testauspainikkeilla.

🚀 Huomaa, että tämän luokan monet metodit eivät ole riippuvaisia käytettävän Map-tietorakenteen tyypistä. Esimerkiksi `countEntries`-metodi voisi toimia yhtä hyvin `<String, String>`- kuin `<String, Integer>`-tyyppisten avainten ja arvojen kanssa. Oikeassa ohjelmassa käyttäisit todennäköisesti geneerisiä tyyppejä, kuten `Map<K, V>`. Tässä tehtävässä ei tarvitse erikseen perehtyä geneerisiin tyyppeihin, mutta voit halutessasi tutustua aiheeseen itsenäisesti ja toteuttaa metodit geneerisinä. Katso lisätietoja tutoriaalista: https://dev.java/learn/generics/.


## Tehtävä 2: [MapExperts.java](./src/main/java/part02/MapExperts.java) (soveltaminen, 30 % pisteistä)

Tässä tehtävässä jatkamme `Map`-operaatioita soveltavien tehtävien muodossa. Tehtävät ovat luonteeltaan haastavampia ja edellyttävät myös laajempaa ongelmanratkaisua kuin yksittäisen metodin käyttöä.

Kuten edellisessä tehtävässä, myös [MapExperts.java](./src/main/java/part02/MapExperts.java) koostuu valmiista metodeista, joiden javadoc-kommentit kertovat, miten metodin tulisi toimia. **Sinun tehtäväsi on lukea kommentit ja toteuttaa metodin sisältö vastaamaan metodin nimeä sekä kuvausta.**

Kuten edellisessä tehtävässä, voit testata koodiasi esimerkiksi oman `main`-metodin tai valmiiden JUnit-yksikkötestien avulla. Testit löytyvät [MapExpertsTest](./src/test/java/part02/MapExpertsTest.java)-luokasta. Voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```sh
./gradlew test --tests MapExpertsTest      # unix
gradlew.bat test --tests MapExpertsTest    # windows
```


## Tehtävä 3: [PostalCodesMain.java](./src/main/java/part03/PostalCodesMain.java) (soveltaminen, 30 % pisteistä)

Tietokoneohjelmat käyttävät usein JSON-tiedostomuotoa rakenteellisen datan käsittelyssä. [JSON (JavaScript Object Notation)](https://www.json.org/) on kevyt ja yleinen tapa tallentaa ja siirtää tietoa ohjelmien välillä. JSON-muotoista dataa voidaan käyttää monissa erilaisissa sovelluksissa, kuten verkkopalvelimissa, mobiilisovelluksissa ja tietokantojen kanssa työskennellessä. JSON-muotoinen data voi näyttää esim. seuraavalta:

```json
{
    "74701": "KIURUVESI",
    "35540": "JUUPAJOKI",
    "74705": "PAKETTIAUTOMAATTI",
    "74704": "SMARTPOST",
    "44884": "SMART POST"
}
```

Java-ohjelmassa Map-tietorakenne soveltuu erinomaisesti yllä esitettyjen avain-arvo-parien käsittelemiseen. Tässä tehtävässä keskitymme postinumeroaineiston käsittelyyn, joka on tallennettu [JSON-muotoiseen tiedostoon nimeltä *postcode_map_light.json*](./data/postcode_map_light.json).

💡 *JSON-tiedoston lukemiseen Java-ohjelmassa käytämme tässä tehtävässä Googlen julkaisemaa [GSON-kirjastoa](https://github.com/google/gson). GSON mahdollistaa JSON-datan muuntamisen Java-olioiksi ja päinvastoin. JSON-tiedoston käsittely on toteutettu valmiiksi [PostalCodes](./src/main/java/part03/PostalCodes.java)-luokassa. Sinun ei tarvitse perehtyä GSON:in yksityiskohtiin tai käyttää sitä itse.*

🚀 *GSON ei ole osa Javan standardikirjastoa, vaan se on lisätty tähän projektiin Gradle-työkalun avulla. Tutki [`build.gradle`](./build.gradle)-tiedostoa, löydätkö miten ja mihin GSON on määritetty?*


### Käyttöliittymä

Edellisistä tehtävistä poiketen tässä tehtävässä saat toteuttaa ratkaisun parhaaksi katsomallasi tavalla ja luoda parhaaksi katsomasi luokat ja metodit. Ohjelmasi on kuitenkin toimittava siten, että se käynnistyy `PostalCodesMain`-luokan main-metodista ja kysyy käyttäjältä ainoastaan yhden kysymyksen. Tulos täytyy myös tulostaa tehtävänannossa esitetyssä muodossa.

Toteuta siis [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java)-luokkaan logiikka, joka hyödyntää [PostalCodes](./src/main/java/part03/PostalCodes.java)-luokan `readPostalCodes`-metodia. Ohjelmasi tulee tulostaa tilanteesta riippuen joko käyttäjän syöttämää postinumeroa vastaavan postitoimipaikan nimen tai nimeä vastaavat postinumerot.

Käyttäjä saattaa siis antaa parametrina numeron, jolloin ohjelma etsii sitä vastaavan toimipaikan nimen:

```
Mitä etsitään (esim. 00100 tai Helsinki)? 00100

Toimipaikka: HELSINKI
```

Yllä olevassa esimerkissä käyttäjä antoi syötteen `00100` ja ohjelma tulosti nimen `HELSINKI`. Mikäli postinumeroa ei löydy aineistosta, tulosta teksti "Postinumeroa ei löytynyt."

Jos käyttäjä syöttää toimipaikan nimen, ohjelman tulee tulostaa kaikki postinumerot, jotka kuuluvat kyseiseen postitoimipaikkaan:

```
Mitä etsitään (esim. 00100 tai Helsinki)? Porvoo

Postinumerot: 06100, 06101, 06150, 06151, 06200, 06400, 06401, 06450, 06500
```

Tässä esimerkissä käyttäjä syötti tekstin `Porvoo` ja ohjelma tulosti Porvoon postinumerot. Mikäli annetulle nimelle ei löydy lainkaan postinumeroita, tulosta "Postinumeroita ei löytynyt." Ohjelmasi tulee löytää postinumerot riippumatta syötetyn nimen kirjainkoosta.

Tulosteessa postinumeroiden tulee olla kasvavassa järjestyksessä pilkuilla eroteltuna, joten kerää postinumerot ensin esimerkiksi listalle, jonka järjestät ennen tulostamista.


### Ohjelman suorittaminen

Voit suorittaa [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java)-pääohjelman joko koodieditorisi käyttöliittymän Run-painikkeella tai Gradle-työkalun avulla komentoriviltä:

```sh
./gradlew -q --console plain run       # unix
gradlew.bat -q --console plain run     # windows
```

💡 *Ensimmäisellä suorituskerralla suoritus saattaa olla hyvin hidas, mutta [suoritus nopeutuu seuraavilla kerroilla Gradlen välimuistin ansiosta](https://docs.gradle.org/current/userguide/build_cache.html). Voit myös vaihtoehtoisesti suorittaa ohjelmasi käyttämäsi koodieditorin "run"-painikkeella.*

🚀 *Gradle osaa suorittaa run-komennolla main-metodin oikeasta Java-luokasta, koska `PostalCodesMain` on määritetty [`build.gradle`](./build.gradle)-tiedostossa pääohjelmaksi.*


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
