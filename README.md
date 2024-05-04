# Surveys
Surveys

Adott egy 300 embert tartalmazó lista, akik kérdőíveket szoktak kitölteni. A résztvevők a kérdőívek kitöltéséért pontokat kapnak, amit beválthatnak 
ajándék és használati tárgyakra.
A kitöltők között vannak aktív és passzív tagok. Aktuálisan csak az aktív tagokat lehet megkérdezni, bár korábban a passzív tagok is részt vehettek 
kutatásokban.

Adott ember adott kérdőívre vonatkozó státusza a következők valamelyike lehet:
- (1) Not asked - Nem vett részt a felmérésben (nem kérték fel)
- (2) Rejected - Nem vett részt a felmérésben (megkérték, de nem akart)
- (3) Filtered - A szűrő kérdések alapján nem felelt meg
- (4) Completed - Kitöltötte a kérdőívet
(3) és (4) esetén kaphatnak pontot a résztvevők.

1. Olvassuk be a szükséges adatokat a Members, Surveys, Statuses és Participation CSV fájlokból az általunk létrehozott megfelelő adatszerkezetekbe.

2. Implementáljuk az alábbi szolgáltatásokat:
	a) Adott kérdőívet kitöltők (Completed státuszúak) listája
	b) Adott személy által kitöltött (Completed státuszú) kérdőívek listája
	c) Adott személy által eddig gyűjtött pontok lekérdezése
	d) Adott kérdőívre meghívható (Még nem vett részt ebben a felmérésben és státusza aktív) személyek listázása
	
Bónusz:	
	e) Összes kérdőív listázása, statisztikákkal:
		Kérdőív azonosító, Kérdőív neve, Kitöltők száma, Kiszűrtek száma, Kérdőívet elutasítók száma, Átlagos kitöltési hossz
	
Megjegyzés:
- Minden számítást Java-ban végezzünk el!
- Teszt lefedettség elõny
