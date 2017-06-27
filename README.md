# Membri del gruppo
* Martina Della Corte
* Lorenzo Mignone
* Viviana Pilosio

# Informazioni sui dipartimenti dell'università "RomaTre".
Il servizio principale RomaTre fornisce informazioni (casuali) sui dipartimenti dell'università.
In particolare restituisce il nome del capo del dipartimento indicato e il valore medio del giudizio di soddisfazione degli studenti di tale dipartimento (un numero intero compreso tra 0 e 10 ottenuto come valore medio dei giudizi espressi dagli studenti sui seguenti indicatori: esercitazioni, aule, lezioni e insegnamento. Ciascun giudizio parziale viene sempre espresso da un numero intero compreso tra 0 e 10).

In particolare il servizio principale offre due operazioni:
 
1. **/RomaTre/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento> e il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.

2. **/RomaTre/&lt;dipartimento>/&lt;indicatore>** restituisce il nome del capo del &lt;dipartimento> e il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>.

Ad esempio,

* la richiesta /RomaTre/Ingegneria potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti di Ingegneria è 8/10".

* la richiesta /RomaTre/Ingegneria/Aule potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti relativo all'indicatore "Aule" di Ingegneria è 8/10"

-----
## Docker
Il progetto include i file necessari all'esecuzione delle singole applicazioni in container docker o come un unico stack di servizi.
Sono presenti in oltre degli script che permettono la compilazione, la costruzione delle immagini e la costruzione dei contenitori in maniera automatica.

---
### Note
Rispetto agli indicatori di valutazione della didattica presentati nel documento abbiamo scelto per semplicità soltanto i 4 menzionati sopra.
