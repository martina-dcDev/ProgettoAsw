### R1
Il servizio R1 fornisce un’operazione:
1. **/R1/&lt;dipartimento>** restituisce il nome del capo del &lt;dipartimento>

Ad esempio,
* la richiesta /R1/Ingegneria potrebbe restituire "Rossi M.".

### Build ed esecuzione del servizio
Per eseguire il servizio R1 occorre per prima cosa farn il build con il comando gradle bootrun.
Dopodiché lo script "run-R1-service.sh" permette l'esecuzione del servizio R1 sulla porta 8081.
