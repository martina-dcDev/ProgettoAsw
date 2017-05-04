### RomaTre, servizio principale
Il servizio principale RomaTre fornisce informazioni (casuali) sui dipartimenti dell'università.
In particolare restituisce il nome del capo del dipartimento indicato e il valore medio del giudizio di soddisfazione degli studenti di tale dipartimento(un numero intero compreso tra 0 e 10 ottenuto come valore medio dei giudizi espressi dagli studenti sui seguenti indicatori: Esercitazioni, Aule, Lezioni e Insegnamento. Ciascun giudizio parziale viene sempre espresso da un numero intero compreso tra 0 e 10).
 In particolare il servizio principale offre due operazioni:
1. **/RomaTre/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento> e il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.
2. **/RomaTre/&lt;dipartimento>/&lt;indicatore>** restituisce il nome del capo del &lt;dipartimento> e il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>.

Ad esempio,
* la richiesta /RomaTre/Ingegneria potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti di questo dipartimento è 8/10".
* la richiesta /RomaTre/Ingegneria/Aule potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti relativo all'indicatore "Aule" di questo dipartimento è 8/10"

### Esecuzione del servizio
Il servizio per essere eseguito deve essere prima compilato.
Lo script "run-RomaTre-service.sh" permette la compilazione e l'esecuzione del servizio.

Il servizio risponde sulla porta 8080 di localhost e necessita che i servizi R1 e R2 siano in esecuzione rispettivamente sulle porte 8081 e 8082 di localhost per poter elaborare le richeiste.
