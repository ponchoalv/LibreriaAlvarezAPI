CREATE TABLE "ventas" (
	"fecha" TIMESTAMPTZ DEFAULT Now(),
	"monto" NUMERIC(12,2) NOT NULL DEFAULT 0,
	"usuario" VARCHAR(50) NOT NULL DEFAULT 'feralv'
)