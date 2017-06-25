### R1
Il servizio R1 fornisce una operazione:
1. **/R1/&lt;dipartimento>** restituisce il nome del direttore del &lt;dipartimento>

Ad esempio,
* la richiesta /R1/Ingegneria potrebbe restituire "Rossi Mario".

### Build ed esecuzione del servizio
Per eseguire il servizio R1 occorre per prima cosa farn il build con il comando "gradle build".
Dopodiché lo script "run-R1-service.sh" permette l'esecuzione del servizio R1 sulla porta 8080.
