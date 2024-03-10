/**
The script converts the Description column of the Experiment table from type VARCHAR to TEXT.
*/	

ALTER TABLE APP.EXPERIMENT ADD COLUMN TMP_COLUMN LONG VARCHAR;
UPDATE APP.EXPERIMENT SET TMP_COLUMN=DESCRIPTION;
ALTER TABLE APP.EXPERIMENT DROP COLUMN DESCRIPTION;
RENAME COLUMN APP.EXPERIMENT.TMP_COLUMN TO DESCRIPTION;