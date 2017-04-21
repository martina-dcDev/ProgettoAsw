# Informazioni su aule e docenti di un’università "RomaTre".
Il servizio principale RomaTre fornisce informazioni su aule e professori di un dipartimento dell’università "RomaTre", ovvero offre due operazioni:
1. **/RomaTre/&lt;dipartimento>** restituisce informazioni (casuali) su &lt;dipartimento> (cognome dei professori che insegnano in quel dipartimento), e informazioni (sempre casuali) sulle aule di quel &lt;dipartimento> (nome dell’aula).
2. **/RomaTre/&lt;dipartimento>/&lt;orario>** restituisce informazioni (casuali) su &lt;dipartimento> (cognome dei professori che insegnano in quel dipartimento) e informazioni (sempre casuali) sulle aule libere per quel &lt;dipartimento> in quello specifico &lt;orario>.

Ad esempio,
* la richiesta /RomaTre/Lettere potrebbe restituire "I professori di Lettere sono: Rossi, Verdi e Bianchi. Le aule sono: L1, L2, L3".
* la richiesta /RomaTre/Lettere/12 potrebbe restituire "I professori di Lettere sono: Rossi, Verdi e Bianchi. Le aule libere alle ore 12 sono: L3, L4".

-------

Il servizio RomaTre è implementato come client di due servizi secondari R1 e R2, con le caratteristiche descritte nel seguito:

Il servizio R1 fornisce un’operazione:
* R1/&lt;dipartimento> restituisce l’elenco dei professori (cognomi casuali. Il numero di professori che vengono mostrati sono in numero prefissato) del &lt;dipartimento> dell’università RomaTre.

	Ad esempio,
	la richiesta /R1/Ingegneria potrebbe restituire "Rossi, Verdi, Bianchi".

Inoltre, il servizio R2 fornisce due operazioni:
* R2/&lt;dipartimento> restituisce le aule presenti nel &lt;dipartimento> dell’università.
* R2/&lt;dipartimento>/&lt;orario> restituisce restituisce le aule libere nel &lt;dipartimento> dell'università all'&lt;orario> specificato.

	Ad esempio,
	la richiesta /R2/Ingegneria potrebbe restituire "N1, N2, N3".
	la richiesta /R2/Ingegneria/12 potrebbe restituire "N1, N2".

Il servizio RomaTre risponde al suo client usufruendo dei servizi R1 e R2 e integrando le loro risposte.
