DROP TABLE llibres;

CREATE TABLE llibres (
    id_llibre INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    editorial VARCHAR(255) NOT NULL,
    data_publicacio DATE NOT NULL,
    tematica VARCHAR(255) NOT NULL

);