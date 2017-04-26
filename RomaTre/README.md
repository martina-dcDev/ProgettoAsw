### RomaTre, servizio principale
Il servizio principale RomaTre fornisce informazioni su aule e professori di un dipartimento dell’università "RomaTre" basandosi sui servizi R1 e R2, ovvero offre due operazioni:
1. **/RomaTre/&lt;dipartimento>** restituisce informazioni (casuali) su &lt;dipartimento> (cognome dei professori che insegnano in quel dipartimento), e informazioni (sempre casuali) sulle aule di quel &lt;dipartimento> (nome dell’aula).
2. **/RomaTre/&lt;dipartimento>/&lt;orario>** restituisce informazioni (casuali) su &lt;dipartimento> (cognome dei professori che insegnano in quel dipartimento) e informazioni (sempre casuali) sulle aule libere per quel &lt;dipartimento> in quello specifico &lt;orario>.

Ad esempio,
* la richiesta /RomaTre/Lettere potrebbe restituire "Nel dipartimento di Lettere sono presenti i seguenti professori: Luca, Mario, Matteo. Sono a disposizione degli studenti le seguenti aule: L1, L2, L3".
* la richiesta /RomaTre/Lettere/12 potrebbe restituire "Nel dipartimento di Lettere sono presenti i seguenti professori: Luca, Mario, Matteo. Le aule libere nell'orario indicato sono: L2, L2".

### Esecuzione del servizio
Il servizio per essere eseguito deve essere prima compilato.
Lo script "start-service.sh" permette la compilazione e l'esecuzione del servizio.

Il servizio risponde sulla porta 8080 di localhost e necessita che i servizi R1 e R2 siano in esecuzione rispettivamente sulle porte 8081 e 8082 di localhost per poter elaborare le richeiste.
