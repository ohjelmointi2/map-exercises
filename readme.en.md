# Map exercises

With this exercise package, you will learn to utilize the Map data structure in your own applications. To support the exercises, we recommend reading the pages [Using Maps to Store Key Value Pairs](https://dev.java/learn/api/collections-framework/maps/) and [Managing the Content of a Map](https://dev.java/learn/api/collections-framework/working-with-keys-and-values/) from the Oracle's [dev.java](https://dev.java/) tutorial.

> *"A hashmap is a structure able to store key-value pairs. The value is any object your application needs to handle, and a key is something that can represent this object.*
>
> *Suppose you need to create an application that has to handle invoices, represented by instances of an Invoice class. Then your values are these Invoice instances, and your keys could be the invoice numbers. Each invoice has a number, and that number is unique among all your invoices."*
>
> Using Maps to Store Key Value Pairs. Oracle. https://dev.java/learn/api/collections-framework/maps/

The task consists of several parts, each of which will be evaluated separately using pre-written tests.

## Starting the exercise

Start by cloning the Git repository to your local machine. The exercise must be done in your own copy, so make sure the repository URL includes your GitHub username! You can create your own copy through the GitHub Classroom link provided in your course assignment.

```sh
git clone https://github.com/make-sure-that-the-repository-address-contains-your-account.git
```

After cloning the project to your local machine, open it in your code editor.

## Submitting solutions

Once you have solved some or all of the tasks and committed your answers, submit the solutions for evaluation using the `git push` command. Git push will automatically trigger a GitHub Actions workflow that compiles and tests your solutions, providing a pass or fail result for each test.

Once the GitHub Actions has executed your code, you see the results in your GitHub repository's [Actions tab](../../actions/workflows/classroom.yml). It usually takes a few minutes for the assesment to be completed. 

By clicking on the latest *"GitHub Classroom Workflow"* execution from the link above, you will get detailed information about the task evaluation. At the bottom of the page, you can see the points you received. By clicking on the "Autograding" heading, you can view the steps performed during the evaluation and their results in more detail. You can find an illustrated guide on this topic in the GitHub documentation [View autograding results (github.com)](https://docs.github.com/en/education/manage-coursework-with-github-classroom/learn-with-github-classroom/view-autograding-results).

## Exercise 1: [MapBasics.java](./src/main/java/part01/MapBasics.java) *(basics, 40 %)*

In this task, we will practice creating a new `Map` object and performing the most common operations for adding, retrieving, modifying, and removing data.

The Java class to be coded in this task, [MapBasics](./src/main/java/part01/MapBasics.java), consists of predefined methods with Javadoc comments explaining how each method should function. **Your task is to read the comments and implement the method content to match the method name and description.**

You can test your code using your own `main` method, or you can utilize the provided JUnit unit tests for the task, which can be found in the [MapBasicsTest](./src/test/java/part01/MapBasicsTest.java) class. 
You can run the tests either using your code editor's testing tool ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or using the [Gradle tool](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests MapBasicsTest        # unix
.\gradlew.bat test --tests MapBasicsTest    # windows
```

💡 *If the tests do not pass, try running the command again with the `--info` argument at the end. This will give you more detailed information about what went wrong in the test. Alternatively, you can run the tests using the testing tool in your code editor ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)), which typically displays errors clearly.*

💡 *You do not need to familiarize yourself with the technical implementation of the actual test. At this stage, it is sufficient to run the tests and review any error messages they may produce.*

🚀 *Note that many methods in this class are not dependent on the type of Map data structure used. For example, the `countEntries` method could work equally well with `<String, String>` as with `<String, Integer>` types of keys and values. In a real program, you would likely use generic types, such as `Map<K, V>`. In this task, you do not need to specifically study generic types, but you can explore the topic independently and implement the methods generically if you wish. For more information, see the tutorial: https://dev.java/learn/generics/.*

## Exercise 2: [MapExperts.java](./src/main/java/part02/MapExperts.java) *(applying, 30 %)*

In this task, we continue with exercises that apply `Map` operations. The tasks are more challenging in nature and require broader problem-solving skills beyond the use of individual methods.

As in the previous task, [MapExperts.java](./src/main/java/part02/MapExperts.java) also consists of predefined methods with Javadoc comments explaining how each method should function. **Your task is to read the comments and implement the method content to match the method name and description.**

As in the previous task, you can test your code using your own `main` method or the provided JUnit unit tests. The tests can be found in the [MapExpertsTest](./src/test/java/part02/MapExpertsTest.java) class. You can run the tests either using your code editor's testing tool ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or using the [Gradle tool](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests MapExpertsTest        # unix
.\gradlew.bat test --tests MapExpertsTest    # windows
```


## Exercise 3: [PostalCodesMain.java](./src/main/java/part03/PostalCodesMain.java) *(applying, 15 % + 15 %)*

Computer programs often use the JSON file format for handling structured data. [JSON (JavaScript Object Notation)](https://www.json.org/) is a lightweight and common way to store and transfer information between programs. JSON-formatted data can be used in many different applications, such as web servers, mobile applications, and working with databases. JSON-formatted data might look like this, for example:

```json
{
    "74701": "KIURUVESI",
    "35540": "JUUPAJOKI",
    "74705": "PAKETTIAUTOMAATTI",
    "74704": "SMARTPOST",
    "44884": "SMART POST"
}
```

In a Java program, the Map data structure is excellent for handling the key-value pairs shown above. In this task, we will focus on processing postal code data stored in a [JSON file named *postcode_map_light.json*](./data/postcode_map_light.json).

💡 *To read the JSON file in a Java program, we will use Google's GSON library in this task. [GSON](https://github.com/google/gson) allows converting JSON data to Java objects and vice versa. The handling of the JSON file has been pre-implemented in the [PostalCodes](./src/main/java/part03/PostalCodes.java) class. You do not need to delve into the details of GSON or use it yourself.*

🚀 *GSON is not part of the Java standard library; it has been added to this project using the Gradle tool. Examine the [`build.gradle`](./build.gradle) file to find out how and where GSON is specified.*

### User interface

Edellisistä tehtävistä poiketen tässä tehtävässä saat toteuttaa ratkaisun parhaaksi katsomallasi tavalla ja luoda parhaaksi katsomasi luokat ja metodit. Ohjelmasi on kuitenkin toimittava siten, että se käynnistyy `PostalCodesMain`-luokan main-metodista ja kysyy käyttäjältä ainoastaan yhden kysymyksen. Tulos täytyy myös tulostaa tehtävänannossa esitetyssä muodossa.

Toteuta siis [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java)-luokkaan logiikka, joka hyödyntää [PostalCodes](./src/main/java/part03/PostalCodes.java)-luokan `readPostalCodes`-metodia. Ohjelmasi tulee tulostaa tilanteesta riippuen joko käyttäjän syöttämää postinumeroa vastaavan postitoimipaikan nimen tai nimeä vastaavat postinumerot.

**Postinumero (15 %)**

Käyttäjä saattaa siis syöttää numeron, jolloin ohjelma etsii sitä vastaavan toimipaikan nimen:

```
Mitä etsitään (esim. 00100 tai Helsinki)? 00100

Toimipaikka: HELSINKI

[ ohjelman suoritus päättyy ]
```

Yllä olevassa esimerkissä käyttäjä antoi syötteen `00100` ja ohjelma tulosti nimen `HELSINKI`. Mikäli postinumeroa ei löydy aineistosta, tulosta teksti "Postinumeroa ei löytynyt."

💡 *Huomaa, että automaattisen arvioinnin vuoksi ohjelman tulee kysyä vain yksi syöte, tulostaa vastaus ja lopettaa.*

**Toimipaikan nimi (15 %)**

Jos käyttäjä syöttää toimipaikan nimen, ohjelman tulee tulostaa kaikki postinumerot, jotka kuuluvat kyseiseen postitoimipaikkaan:

```
Mitä etsitään (esim. 00100 tai Helsinki)? Porvoo

Postinumerot: 06100, 06101, 06150, 06151, 06200, 06400, 06401, 06450, 06500

[ ohjelman suoritus päättyy ]
```

Tässä esimerkissä käyttäjä syötti tekstin `Porvoo` ja ohjelma tulosti Porvoon postinumerot. Mikäli annetulle nimelle ei löydy lainkaan postinumeroita, tulosta "Postinumeroita ei löytynyt." Ohjelmasi tulee löytää postinumerot riippumatta syötetyn nimen kirjainkoosta.

Tulosteessa **postinumeroiden tulee olla kasvavassa järjestyksessä pilkuilla eroteltuna**, joten kerää postinumerot ensin esimerkiksi listalle, jonka [järjestät](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html#sort(java.util.List)) ennen tulostamista.


### Ohjelman suorittaminen

Voit suorittaa [PostalCodesMain](./src/main/java/part03/PostalCodesMain.java)-pääohjelman joko koodieditorisi käyttöliittymän Run-painikkeella tai Gradle-työkalun avulla komentoriviltä:

```
./gradlew --quiet --console plain run         # unix
.\gradlew.bat --quiet --console plain run     # windows

# -q, --quiet         Log errors only.
# --console [plain]   Specifies which type of console output to generate.
#                     Values are 'plain', 'auto' (default), 'rich' or 'verbose'.
```

💡 *Ensimmäisellä suorituskerralla suoritus saattaa olla hyvin hidas, mutta [suoritus nopeutuu seuraavilla kerroilla Gradlen välimuistin ansiosta](https://docs.gradle.org/current/userguide/build_cache.html). Voit myös vaihtoehtoisesti suorittaa ohjelmasi käyttämäsi koodieditorin "run"-painikkeella.*

🚀 *Gradle osaa suorittaa run-komennolla main-metodin oikeasta Java-luokasta, koska `PostalCodesMain` on määritetty [`build.gradle`](./build.gradle)-tiedostossa pääohjelmaksi.*


### Tehtävän testaaminen

Nämä postinumerotehtävät testataan käyttöliittymän kautta, joten niille ei ole aikaisemmista tehtävistä poiketen valmiita yksikkötestejä. Sinun on siis testattava ratkaisusi toimivuus itse suorittamalla ohjelman `main`-metodia ja tarkastamalla sen antamat tulokset. Valmis [PostalCodesTest](./src/test/java/part03/PostalCodesTest.java)-luokka tarkastaa vain, että [valmiiksi annettu koodi postinumeroiden lukemiseksi tiedostoista](./src/main/java/part03/PostalCodes.java) toimii kuten pitääkin, mutta se ei testaa toteuttamaasi pääohjelmaa.


## Bonustehtävä 4: [MorseCode.java](./src/main/java/part04/MorseCode.java) *(soveltaminen, 0 %)*

Tämä on bonustehtävä, joka ei sisälly tehtävän arviointiin. Voit halutessasi toteuttaa [MorseCode-luokan](./src/main/java/part04/MorseCode.java) ja siihen liittyvän [MorseApp-luokan](./src/main/java/part04/MorseApp.java), tai voit jättää tämän tehtävän väliin.

MorseCode-luokkaan on toteutettava kaksi metodia: `morseToText` ja `textToMorse`. Nämä metodit muuntavat merkkijonoja morsekoodista "normaaliksi" tekstiksi ja päinvastoin:

```
hello world
.... . .-.. .-.. ---   .-- --- .-. .-.. -..
```

Lisätietoja morsekoodista löytyy esimerkiksi Wikipediasta: [https://en.wikipedia.org/wiki/Morse_code](https://en.wikipedia.org/wiki/Morse_code).

MorseCode-luokalle on valmiit testit, jotka löytyvät [MorseCodeTest](./src/test/java/part04/MorseCodeTest.java)-luokasta. Voit suorittaa testit koodieditorisi testaustyökalulla ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) tai [Gradle-automaatiotyökalulla](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests MorseCodeTest        # unix
.\gradlew.bat test --tests MorseCodeTest    # windows
```

---------

## Postinumeroaineiston tekijänoikeudet

Tässä projektissa hyödynnettävä postinumeroaineisto [postcode_map_light.json](./data/postcode_map_light.json) on lainattu [https://github.com/theikkila/postinumerot](https://github.com/theikkila/postinumerot)-projektin [postcode_map_light.json](https://github.com/theikkila/postinumerot/blob/master/postcode_map_light.json)-tiedostosta 7.6.2023.

Datan tekijänoikeudet kuuluvat Postille ja niitä käytetään [Postin käyttöehtojen mukaisesti](https://www.posti.fi/fi/asiakastuki/postinumerotiedostot). Mikäli teet kopioita tästä aineistosta, huolehdi [käyttöehtojen](https://www.posti.fi/fi/asiakastuki/postinumerotiedostot) noudattamisesta.


## Ohjelmoinnin MOOC

`MapExperts`-luokan metodeissa on otettu vahvasti vaikutteita Helsingin yliopiston Ohjelmoinnin perusteet -MOOC-kurssin Python-kielisistä tehtävistä osoitteessa https://ohjelmointi-23.mooc.fi/osa-5. Ohjelmoinnin MOOC on lisensoitu CC BY-NC-SA 4.0 -lisenssillä:

> *Kurssimateriaalin ja tehtävien tekijät ovat Erkki Kaila, Antti Laaksonen ja Matti Luukkainen. Muutama kurssin tehtävistä on Arto Hellaksen (né Vihavainen) käsialaa.*
>
> *Kurssin materiaali on lisensoitu [Creative Commons BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.fi) -lisenssillä, joten voit käyttää ja levittää sitä vapaasti, kunhan alkuperäisten tekijöiden nimiä ei poisteta. Jos teet muutoksia materiaaliin ja haluat levittää muunneltua versiota, se täytyy lisensoida samalla lisenssillä. Materiaalien käyttö kaupalliseen tarkoitukseen on ilman erillistä lupaa kielletty.*


## Tämän tehtävän tekijänoikeudet

Tämän tehtävän on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. Tehtävänannon, tehtäväpohjien ja automaattisten testien luonnissa on hyödynnetty ChatGPT 3.5 -kielimallia sekä GitHub Copilot -tekoälytyökalua.
