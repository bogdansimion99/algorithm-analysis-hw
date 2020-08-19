Simion Bogdan - Alexandru, 323CD

	Cele trei programe analizează complexitatea algoritmilor discutați la 
Etapa 1 (Floyd - Warshall, Dijkstra și Johnson). Le voi explica pe scurt 
implementarea, dar mai întâi de toate, am de făcut câteva mențiuni.
	Astfel, cei trei algoritmi au fost scriși în limbajul Java folosind
compilatorul JDK 12. De asemenea, am folosit o bibliotecă în plus pentru a
implementa mai ușor algoritmul Dijkstra. Datorită limbajului Java, am spart 
funcționalitatea codului în mai multe fișiere de tip *.java (unde sunt
implementate clasele ce au fost utile în scrierea algoritmului). De exemplu,
pentru fiecare algoritm am scris câte o clasă pentru citirea datelor din
fișierul de intrare, cât și pentru scrierea datelor în fișierul de ieșire. 
Precizez faptul că am respectat aceeași structură la fișierul de ieșire, în
sensul că returnez o matrice a costurlor minime pentru graful respectiv. De
asemenea, țin să menționez că algoritmii rulează pe grafuri orientate și
respectă intrările și ieșirile date din arhivă.
	
1. Algoritmul Floyd - Warshall
	Acest algoritm nu este foarte complicat, dându-i-se la intrare o matrice a
costurilor inițiale, iar la ieșire returnează o matrice a costurilor finale.
	Implementarea principala este în fișierul FloydWarshall.java, care iterează
prin fiecare element al matricii de la intrare și dacă există un nod intermediar
pentru care costul dintre cele două noduri este mai mic, atunci acel element din
matrice va primi suma costurilor dintre nodul intermediar și cele două noduri.

2. Algoritmul Dijkstra (adaptat la costul minim între oricare două noduri)
	Acest algoritm, destul de popular printre problemele ce necesită aflarea
costului minim dintre două noduri are ca date de intrare o listă de adiacență,
iar la ieșire returnează tot o matrice de costuri.
	Partea cea mai consistentă a implementării se află in fișierul
Dijkstra.java. Țin să menționez că am implementat algoritmul Dijkstra folosind
coada de priorități, împreună cu reprezentarea grafurilor sub formă de liste.
Lista de adiacență am implementat-o folosind un vector de LinkedList<Edge>, unde
Edge reprezintă clasa pentru muchii, ce conține membrii start (nodul de începere
al muchiei), finish (nodul de terminare al muchiei) și cost (ponderea nodului
respectiv). Mi s-a părut mai ușor de implementat lista de adiacență în acest mod
deoarece, prin natura clasei Edge am putut să găsesc ușor nodurile adiacente. În
plus, vectorul mă ajută să iterez mai bine prin muchii. Menționez faptul că
muchia se află doar la indicele i din listă, unde i este nodul de start al
muchiei.
	Algoritmul constă, mai întâi, în crearea unei cozi de prioritate, dar și a
vectorului final de costuri asociat nodului de start specificat în argumentul
metodei ce implementează algoritmul. În această coadă, nou formată, am introdus
muchiile ce pornesc de la nodul de la care încep să calculez. Apoi, cât timp
toate nodurile nu au fost vizitate (am acoperit cazul în care am un nod izolat),
atunci verifică dacă există un cost mai mic (din coadă) decât cel existent, iar
în caz afirmativ, înlocuiește-l. La final, scoate din coadă muchia cea mai puțin
costisitoare (deci cea folosită) și adaugă în coadă următoarea listă de muchii
aferentă următorului nod ce va fi vizitat. La final, se va returna costul de la
nodul x la celelalte, sub forma unui vector, iar repetând procesul pentru toate
nodurile, se va returna matricea finală de costuri.

3. Algoritmul Johnson
	Acest algoritm primește la intrare o listă de adiacență (din motive de
eficiență) și la ieșire va returna tot o matrice de costuri.
	Aici, partea cea mai consistentă a implementării se află în fișierul
Johnson.java. În această clasă implementez acea parte a algoritmului
Bellman-Ford în care încerc să fac toate costurile pozitive. Astfel, creez un
nou graf pornind de la cel inițial în care adaug un nod nou, ce este legat la
toate celelalte noduri prin muchii cu costul inițial 0. Apoi modific costul
muchiilor astfel încât drumul de la nodul nou adăugat să fie cel mai mic, iar
după aceea, verific dacă nu cumva există cicluri cu costuri negative în graf,
iar dacă există, atunci se va afișa un mesaj corespunzător.
	La final, după ce am aplicat Bellman-Ford (în cazul în care am muchii
negative), aplic Dijkstra pe noul graf și returnez matricea finală de costuri.

Concluzie & Bibliografie

	Pentru a putea să realizez acești algoritmi, am citit posibilele 
implementări făcute pe mai multe site-uri. Printre acestea, se numără:
1. https://algorithms.tutorialhorizon.com/
dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation/
2. https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
3. https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
4. https://www.geeksforgeeks.org/johnsons-algorithm-for-all-pairs-shortest-paths-implementation/
5. https://www.geeksforgeeks.org/bellman-ford-algorithm-simple-implementation/