DELIMITER $$
DROP PROCEDURE IF EXISTS `SP_CALCULATOR` $$
CREATE PROCEDURE `SP_CALCULATOR`(
  IN operation INT,
  IN num1 double,
  IN num2 double
)
BEGIN

  DECLARE res double DEFAULT 0;

  SET res = 
  (
    CASE 
      WHEN operation = 1 THEN num1 + num2
      WHEN operation = 2 THEN num1 - num2
      WHEN operation = 3 THEN num1 * num2
      WHEN operation = 4 THEN num1 / num2
    END
  );

  select res as Result;

END $$
DELIMITER ;


-- Run the procedure
CALL SP_CALCULATOR(1, 2, 3);
