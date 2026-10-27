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

# Tekniker (Kurskrav)
- OpenAI API (gpt-4o) – chatbot
- Stripe för testköp
#  Teknikstack
- Java 21, Spring Boot, Docker, DigitalOcean, MySQL
