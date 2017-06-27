# Membri del gruppo
* Martina Della Corte
* Lorenzo Mignone
* Viviana Pilosio

# Il progetto
Questo progetto contiene l'applicazione romatre-9006
e gli script per il suo rilascio sullo swarm docker **swarm.inf.uniroma3.it**. 

 L'applicazione è accessibile al link [http://swarm.inf.uniroma3.it:9006/](http://swarm.inf.uniroma3.it:9006/). 
 
# Premessa
Copiare nella cartella *swarm.inf.uniroma3.it/resources/certs* i certificati. 

# L'applicazione romatre-9006 : descrizione
Il servizio principale RomaTre fornisce informazioni (casuali) sui dipartimenti dell'università.
In particolare restituisce il nome del capo del dipartimento indicato e il valore medio del giudizio di soddisfazione degli studenti di tale dipartimento (un numero intero compreso tra 0 e 10 ottenuto come valore medio dei giudizi espressi dagli studenti sui seguenti indicatori: esercitazioni, aule, lezioni e insegnamento. Ciascun giudizio parziale viene sempre espresso da un numero intero compreso tra 0 e 10).

In particolare il servizio principale offre due operazioni:
 
1. **/RomaTre/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento> e il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.

2. **/RomaTre/&lt;dipartimento>/&lt;indicatore>** restituisce il nome del capo del &lt;dipartimento> e il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>.

Ad esempio,

* la richiesta /RomaTre/Ingegneria potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti di Ingegneria è 8/10".

* la richiesta /RomaTre/Ingegneria/Aule potrebbe restituire "Il capo del dipartimento di Ingegneria è Rossi M. e il valore medio del giudizio di soddisfazione degli studenti relativo all'indicatore "Aule" di Ingegneria è 8/10"

-----

Il servizio RomaTre è implementato come client di due servizi secondari R1 e R2, con le caratteristiche descritte nel seguito:

Il servizio R1 fornisce un’operazione:
1. **/R1/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento>

Ad esempio,
* la richiesta /R1/Ingegneria potrebbe restituire "Rossi M.".

Inoltre, il servizio R2 fornisce due operazioni:
1. **/R2/&lt;dipartimento>** restituisce il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.
2. **/R2/&lt;dipartimento>/&lt;indicatore>** restituisce il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>

Ad esempio,
* la richiesta /R2/Ingegneria potrebbe restituire "5".
* la richiesta /R2/Ingegneria/Aule potrebbe restituire "3".

Il servizio RomaTre risponde al suo client usufruendo dei servizi R1 e R2 e integrando le loro risposte. Per usufruire di R1 ed R2, RomaTre si avvale del servizio di service discovery offerto da Eureka presso il quale R1 ed R2 sono registrati. Inoltre viene utilizzato Zuul per fornire un punto di accesso unificato all'intera applicazione.
