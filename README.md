# RainBootBackend
- Länk till den deployade sidan: http://178.62.234.61
- För att utföra betalningar via Stripe använder du testkortet med kortnummer 4242 4242 4242 4242, valfritt framtida datum och valfri CVC.
- Det här är backendrepot för mitt projektarbete som är en webbshop där man kan köpa gummistövlar och paraplyer och betala via Stripe. Den är byggd med Angular för frontend och Java med Spring Boot för backend.
  
# Följ dessa steg för att starta projektet lokalt
- Säkerställ att du har Docker Desktop och en kodeditor installerat.
- Klona repot och spara det lokalt på din dator.
- Öppna projektet i din IDE.
- Skapa .env bredvid .env.example och fyll i den med dina egna värden (Tänk på att .env och compose-filen ligger i mappen rain-boot-webshop, inte i repots rot)
- Kör kommandot "cd rain-boot-webshop" och sedan "docker compose up --build" i terminalen. (Nu startar backenden och databasen på http://localhost:8080)
- Starta frontenden, instruktioner för att göra det finns i frontend-readmen. Länk till frontendrepo: https://github.com/firpen/rain-boot-frontend

# Hur har jag använt generativ AI för projektet?
- Jag har använt ChatGPT och Gemini för att generera alla bilder för produkter i applikationen.
- Jag har använt Claude för att förklara hur man läser Stripe-dokumentationen och även tagit hjälp för implementationen av Stripe tillsammans med dokumentationen.
- Jag har även använt Claude för att förklara och skapa Dockerfilen samt docker-compose.yml för att kunna deploya projektet på min droplet på DigitalOcean.
- Jag har även använt Claude för viss felsökning, och för att lösa hur man hämtar size med instanceof när produkten är en RainBoot.
- Jag har använt Claude för att ta ställa frågor kring er-diagrammet för databasen, data.sql-filen och sql-syntaxen för att inserta produkter i databasen.

# Arbetssätt och lärande
- Stripe, databasstrukturen, Docker och varukorgen var nog det svåraste med applikationen. 
## Tester
- För att skriva testerna använde jag mig av den här YouTube-videon: https://www.youtube.com/watch?v=XVFqOFKGeGM
- Jag har nästan aldrig skrivit tester förut därför kändes det som ett stort hinder men när jag väl kom igång var det faktiskt inte så svårt.
## Chatbot
- Chatboten byggde jag med hjälp av kursmaterialet på Plugga.tech, det var även material som vi arbetat med veckan innan så det hade jag ganska bra koll på.
## Databas
- För att få databasstrukturen på plats började jag med att skapa ett ER-diagram. Eftersom jag endast haft enklare relationer i mina tidigare applikationer fick jag ta Claude till hjälp för att förklara vilka relationer jag behövde.
- Sedan skapade jag mina databasmodeller utifrån ER-diagrammet med hjälp av den här dokumentationen: https://www.baeldung.com/spring-data-rest-relationships
- Min produktklass är en abstrakt klass som mina produkter ärver från. Jag använde mig av Joined Table för att hantera dessa relationer. Här tog jag en del hjälp av AI samt den här dokumentationen: https://www.baeldung.com/hibernate-inheritance
## Stripe
- För att få Stripe på plats använde jag mig av den här dokumentationen:  https://docs.stripe.com/checkout/quickstart  https://docs.stripe.com/api/checkout/sessions/create
- Jag tog hjälp av AI för att förstå builderstrukturen i dokumentationen.
## Docker/Deployment
- Jag använde mig av en Droplet på DigitalOcean för första gången för att deploya applikationen.
- Här tog jag hjälp av AI för att veta vilka commands jag ska köra i terminalen och för att containerisera både frontenden och backenden med Docker.
## Varukorg
- Varukorgen var mycket mer omfattande än jag anade från början. Jag lyckades tillslut få till den mestadels på egen hand men visst blev det någon enstaka fråga till Claude och kanske lite hjälp för felsökning.
   
# Tekniker (Kurskrav)
- OpenAI API (gpt-4o) – chatbot
- Stripe för testköp
  
#  Teknikstack
- Java 21, Spring Boot, Docker, DigitalOcean, MySQL
