# Loggbok projekt 2022-02-28

## Inledning

Syftet med projektet var att genom en MVC modell skapa någon typ av loggbok där 
man kan skriva in en flera loggentries som innehåller ett meddelande och en författare.

Loggentries är ett eget objekt som även innehåller en createdAt, updatedAt och en 
updatehistory. Sedan ska man även kunna spara och öppna hela loggboken i en 
separat fil.

View delen kunde varit vad som helst men jag valde Java swing eftersom det går 
relativt snabbt och enkelt.

## Bakgrund

Objekt orienterade delen av projektet är enbart i form av själva Loggentries.
Det objektet ligger i centrum för hela projektet men utöver det behövs inga andra 
objekt.

MVC modellen gjordes lite fuskigt. Jag skrev praktiskt taget allt i Controller 
till en början innan jag helt enkelt formaterade om funktionerna till modellen.

Det största problemet hamnade i att skapa en updatehistory för varje logg.
Grunden var att skapa en arraylist med loggentries där jag helt enkelt slängde in 
gamla loggentryn i arraylisten innan jag ändrade på något värde. Problemet låg i 
att jag lade till 'this' inuti en funktion i loggentriet vilket visst gjorde så 
att objektet i arraylisten uppdaterades med att jag uppdaterade den originella 
loggentryn. Lösningen blev att istället stoppa in en kopia av loggentryn med 
exakt samma värden innan jag redigerade den.

## Positiva erfarenheter

Det som gick best var att spara och öppna filerna eftersom det var simpelt nog att 
kopiera lite gammal kod för att välja en fil. 

Att få viewn och controllern (och senare modellen) att kommunicera med varandra 
gick även bra, mest pga gammal erfarenhet med mvc-modellen.

Här beskriver du vad som har gått bra i ditt projekt och analyserar varför. Hur ska du upprepa framgångarna.

## Negativa erfarenheter

Java swing är bra för att skapa en basic gui för användaren som åtminstone gör 
det den ska men fan i mig om det är svårt att få det att se snyggt ut. Inget 
gigantiskt problem eftersom fokuset fortfarande ligger i det tekniska snarare 
än det grafiska.

## Sammanfattning

Jag har lärt mig lite mer om filhantering gällande objekt snarare än bara text 
och vidareutvecklat mina kunskaper om någon form av mvc-modell och OOP.

Största utvecklingsmöjligheten ligger i lite bättre grafik. Exempelvis redigerings  
knappen öppnar just nu bara en JOptionPane medan det skulle vara mil mycket bättre 
med antingen en dedikerad swing view för det eller att göra den originella viewn 
lite mer dynamisk och öppna upp någon ny textwindow för att redigera meddelandet.