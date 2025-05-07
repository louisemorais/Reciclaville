CREATE TABLE client (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        cnpj VARCHAR(255) NOT NULL UNIQUE,
                        economic_activity VARCHAR(255) NOT NULL,
                        accontable VARCHAR(255) NOT NULL
);

CREATE TABLE material (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          compensation_of_percentage DOUBLE PRECISION NOT NULL
);

CREATE TABLE declaration (
                             id BIGSERIAL PRIMARY KEY,
                             client_id BIGINT NOT NULL,
                             date_of_declaration DATE NOT NULL,
                             start_date DATE NOT NULL,
                             end_date DATE NOT NULL,
                             material_total DOUBLE PRECISION,
                             compensation_total DOUBLE PRECISION,
                             CONSTRAINT fk_declaration_client FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE declaration_item (
                                  id BIGSERIAL PRIMARY KEY,
                                  declaration_id BIGINT NOT NULL,
                                  material_id BIGINT NOT NULL,
                                  percentage DOUBLE PRECISION NOT NULL,
                                  tons_declared DOUBLE PRECISION NOT NULL,
                                  tons_compensation DOUBLE PRECISION NOT NULL,
                                  CONSTRAINT fk_item_declaration FOREIGN KEY (declaration_id) REFERENCES declaration(id),
                                  CONSTRAINT fk_item_material FOREIGN KEY (material_id) REFERENCES material(id)
);