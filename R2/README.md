### R2
Il servizio R2 fornisce due operazioni:
* **R2/&lt;dipartimento>** restituisce le aule presenti nel &lt;dipartimento> dell’università.
* **R2/&lt;dipartimento>/&lt;orario>** restituisce restituisce le aule libere nel &lt;dipartimento> dell'università all'&lt;orario> specificato.

Ad esempio,
* la richiesta /R2/Ingegneria potrebbe restituire "N1, N2, N3".
* la richiesta /R2/Ingegneria/12 potrebbe restituire "N1, N2".
