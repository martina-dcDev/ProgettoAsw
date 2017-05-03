# Informazioni sui Dipartimenti dell'università "RomaTre".
Il servizio principale RomaTre fornisce informazioni (casuali) sui dipartimenti dell'università.
In particolare restituisce il nome del capo del dipartimento indicato e il valore medio del giudizio di soddisfazione degli studenti di tale dipartimento(un numero intero compreso tra 0 e 10 ottenuto come valore medio dei giudizi espressi dagli studenti sui seguenti indicatori: Esercitazioni, Aule, Lezioni e Insegnamento. Ciascun giudizio parziale viene sempre espresso da un numero intero compreso tra 0 e 10).
 In particolare il servizio principale offre due operazioni:
1. **/RomaTre/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento> e il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.
2. **/RomaTre/&lt;dipartimento>/&lt;indicatore>** restituisce il nome del capo del &lt;dipartimento> e il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>.

Ad esempio,
* la richiesta /RomaTre/Ingegneria potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti di Ingegneria è 8/10".
* la richiesta /RomaTre/Ingegneria/Aule potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti relativo all'indicatore "Aule" di Ingegneria è 8/10"

-------

Il servizio RomaTre è implementato come client di due servizi secondari R1 e R2, con le caratteristiche descritte nel seguito:

Il servizio R1 fornisce un’operazione:
1. **R1/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento>

Ad esempio,
* la richiesta /R1/Ingegneria potrebbe restituire "Rossi M.".

Inoltre, il servizio R2 fornisce due operazioni:
1. **R2/&lt;dipartimento>** restituisce il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.
2. **R2/&lt;dipartimento>/&lt;indicatore>** restituisce il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>

Ad esempio,
* la richiesta /R2/Ingegneria potrebbe restituire "5".
* la richiesta /R2/Ingegneria/Aule potrebbe restituire "3".

Il servizio RomaTre risponde al suo client usufruendo dei servizi R1 e R2 e integrando le loro risposte.

-----
N.B.: è possibile visualizzare una panoramica della valutazione della didattica da parte degli studenti frequentanti al seguente link

http://host.uniroma3.it/uffici/nucleo/archivio/db/relazioni/Relazione_valutazione_didattica_10-11.pdf

Rispetto agli indicatori di valutazione della didattica presentati nel documento abbiamo scelto per semplicità soltanto i 4 menzionati sopra.
