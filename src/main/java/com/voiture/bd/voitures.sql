 CREATE TABLE `voitures` (
  `idVoiture` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `marque` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `modele` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `couleur` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `immatriculation` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `kilometrage` int NOT NULL,
  `prix` float(10) COLLATE utf8_unicode_ci NOT NULL,
  `statut` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  CONSTRAINT `voitures_idVoiture_PK` PRIMARY KEY(`idVoiture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `voitures` (`idVoiture`, `marque`, `modele`, `couleur`, `immatriculation`, `kilometrage`, `prix`, `statut`) VALUES
('ID001', 'Acura', 'TLX', 'Noir', 'AA692RK', '00053', '69.00', 'Dispo'),
('ID002', 'Hyundai', 'Elantra', 'Noir', 'FR905MG', '01689', '39.00', 'Louée'),
('ID003', 'Acura', 'Vigor', 'Blanc', 'HJ555TA', '45507', '30.00', 'Louée'),
('ID004', 'Ford', 'Escape', 'Bleu Nuit', 'XR602VV', '24033', '50.45', 'Louée'),
('ID005', 'Hyundai', 'Santa Fe', 'Gris Anthracite', 'LM455DE', '08970', '60.99', 'Dispo'),
('ID006', 'Hyundai', 'Tucson', 'Noir', 'GO114WQ', '19995', '47.99', 'Louée'),
('ID007', 'Mazda', 'CX3', 'Blanc', 'AQ002RS', '00994', '45.00', 'Dispo'),
('ID008', 'Kia', 'Sorento', 'Bleu Electrique', 'PO123FK', '24678', '49.00', 'Louée'),
('ID009', 'Alfa Romeo', 'Brera', 'Rouge Mat', 'DD672RE', '05890', '69.00', 'Louée'),
('ID010', 'Audi', 'RS6', 'Noir', 'BA092AK', '08889', '89.00', 'Dispo'),
('ID011', 'Mazda', 'CX5', 'Gris', 'AF192RT', '11378', '79.00', 'Louée'),
('ID012', 'Audi', 'A3', 'Gris', 'VA695ZZ', '08833', '59.00', 'Dispo');