# RomaTre, servizio principale
Il servizio principale RomaTre fornisce informazioni (casuali) sui dipartimenti dell'universita'.
In particolare restituisce il nome del direttore del dipartimento indicato e il valore medio del giudizio di soddisfazione degli studenti di tale dipartimento (un numero intero compreso tra 0 e 10 ottenuto come valore medio dei giudizi espressi dagli studenti sui seguenti indicatori: Esercitazioni, Aule, Lezioni e Insegnamento. Ciascun giudizio parziale viene sempre espresso da un numero intero compreso tra 0 e 10).
In particolare il servizio principale offre due operazioni:
1. **/RomaTre/&lt;dipartimento>** restituisce il nome del direttore del &lt;dipartimento> e il valore medio del giudizio degli studenti riguardo a quel &lt;dipartimento>.
2. **/RomaTre/&lt;dipartimento>/&lt;indicatore>** restituisce il nome del direttore del &lt;dipartimento> e il valore medio dell' &lt;indicatore> relativo a quel &lt;dipartimento>.

Ad esempio,
* la richiesta /RomaTre/Ingegneria potrebbe restituire "Il direttore del dipartimento di Ingegneria e' Rossi M. e il valore medio del giudizio di soddisfazione degli studenti di questo dipartimento e' 8/10".
* la richiesta /RomaTre/Ingegneria/Aule potrebbe restituire "Il direttore del dipartimento di Ingegneria e' Rossi M. e il valore medio del giudizio di soddisfazione degli studenti relativo all'indicatore "Aule" di questo dipartimento e' 8/10"

### Ambiente Docker
Il servizio può essere avviato in un container Docker.
L'individuazione dei servizi di R1 e R2 è effettuata da Eureka, mentre l'API gateway è fornito da Zuul.
Per questo è necessario che sia i servizi R1 e R2  che i servizi Eureka e Zuul siano in esecuzione in container Docker separati.
L'orchestrazione è effettuata da Docker Swarm.

### Esecuzione del servizio
Per l'esecuzione del servizio e dell'applicazione in generale sono stati forniti alcuni script con estensione .sh.