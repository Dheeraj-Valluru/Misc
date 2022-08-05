-- CS3200_HW4_EMR.sql

-- CS3200 / HOMEWORK #4 
-- Write a query against the Electronic Medical Record (EMR) database than answers each question
-- Remember to save your script as: CS3200_HW4_yourname.sql

use emr;


-- 1. List each patient and the name of their primary care doctor (PCP)
-- Output just the patient name and the doctor's name in
-- alphabetical order by patient

SELECT 
    p.patient_name, d.doctor_name
FROM
    patient p
        LEFT JOIN
    diagnosis di USING (patient_id)
        LEFT JOIN
    doctor d USING (doctor_id)
ORDER BY p.patient_name ASC;


-- 2. How many doctors are there for each specialty?
-- Include specialties that have no doctor.
-- Order by most doctors to fewest

SELECT 
     s.specialty_name, COUNT(d.doctor_id)
FROM
    doctor d
        LEFT JOIN
    specialty s USING (specialty_id)
GROUP BY s.specialty_name
ORDER BY COUNT(d.doctor_id) DESC;


-- 3. Which patients have the flu?
-- Output the patient name, their flushot status, the diagnosing doctor's name, and the date of the diagnosis
-- sort by diagnosis date

SELECT 
    p.patient_name, p.flushot, d.doctor_name, di.diagnosis_date
FROM
    patient p
        LEFT JOIN
    diagnosis di USING (patient_id)
        LEFT JOIN
    doctor d USING (doctor_id)
    left join 
    disease dis using (disease_id)
    where dis.disease_id = 2
GROUP BY p.patient_name
ORDER BY di.diagnosis_date DESC;

-- 4. What is the BMI for each patient?
-- BMI = Body Mass Index
-- Look up the definition and formula on the internet. Don't forget unit conversions.
-- Note that patient table provides weight in lbs and height in inches!
-- Output patient_id, Patient name, weight (lbs), height (inches), and BMI rounded to 1 decimal place
-- Order by BMI descending

SELECT 
    p.patient_id,
    p.patient_name,
    p.weight,
    p.height,
    ROUND((weight / (height * height)) * 703, 1) AS BMI
FROM
    patient p
ORDER BY BMI DESC;

-- 5. Write an INSERT statement that adds to the recommendation table
-- the patient_id and the text "Recommend Diet and Exercise"
-- for any patient with a BMI greater than 25.0.

insert into recommendation
(select patient_id, "Recommend Diet and Exercise"
from patient p 
where  ROUND((p.weight / (p.height * p.height)) * 703, 1) > 25.0);

select * from recommendation;

-- 6. Write a query to delete flushot recommendations for any patient that has had their flushot

DELETE FROM recommendation 
WHERE
    patient_id IN (SELECT 
        patient_id
    FROM
        patient p
    
    WHERE
        p.flushot = 1)
    AND message LIKE 'Recommend getting a flushot';

select * from recommendation;

-- 7. Write a query that outputs a patients name, sex, dob, flushot status, weight
-- and any recommendations. Include patients with no recommendations

SELECT 
    p.patient_name, p.sex, p.dob, p.flushot, p.weight, r.message
FROM
    patient p
        LEFT JOIN
    recommendation r USING (patient_id);


-- 8. Show the medical history for patient 'Smith
-- Output the patient name, the name of their PCP, the diagnosing doctor, the diagnosis (disease) and date
-- Clearly distinguish the doctor who is the PCP and the diagnosing doctor in your column headers.
-- Order from newest to oldest diagnosis

SELECT 
    p.patient_name,
    d.doctor_name,
    diag_d.doctor_name,
    dis.disease_name,
    dia.diagnosis_date
FROM
    patient p
        JOIN
    doctor d ON p.pcp_id = d.doctor_id
        JOIN
    diagnosis dia USING (patient_id)
        JOIN
    doctor diag_d ON diag_d.doctor_id = dia.doctor_id
        JOIN
    disease dis USING (disease_id)
WHERE
    p.patient_name = 'Smith'
ORDER BY dia.diagnosis_date DESC;

-- 9. Output every doctor and their specialty
-- include doctors with no specialty
-- include specialties with no doctor

SELECT 
    doctor_name, s.specialty_name
FROM
    doctor d
        LEFT JOIN
    specialty s ON d.specialty_id = s.specialty_id 
UNION SELECT 
    doctor_name, s.specialty_name
FROM
    doctor d
        RIGHT JOIN
    specialty s ON d.specialty_id = s.specialty_id;
-- left join specialty using (specialty_id);

-- 10. How many times was each disease in the disease table
-- diagnosed in 2017? Include diseases that were never diagnosed.
-- Output the disease and the number of times it was diagnosed in 2017
-- Order by the number of diagnoses descending
-- HINT: This one is tricky. Check your result carefully. You should output 5 records one for each disease
-- 3 of the diseases have no diagnosis in 2017. 
-- The trick is that one of your join tables can be the result of a select!

SELECT 
    disease_name, COUNT(patient_id)
FROM
    disease 
        LEFT JOIN
    (select * from diagnosis WHERE
    YEAR(diagnosis_date) >= 2017) as temp
    using (disease_id)
    GROUP BY disease_name
    ORDER BY COUNT(patient_id) desc;



-- 11. For each doctor that is the PCP of at least one patient
-- What is the min, max, and average weight of that doctor's patients?
-- Round avg_weight to one decimal place
-- Also count the number of patients that that doctor has
-- Order by the average weight descending
-- Use column aliases to output the column: doctor_name, min_weight, avg_weight, max_weight, num_patients

SELECT 
    d.doctor_name AS 'doctor_name',
    MIN(p.weight) AS 'min_weight',
    MAX(p.weight) AS 'max_weight',
    ROUND(AVG(p.weight), 1) AS 'avg_weight',
    COUNT(p.patient_id) AS 'num_patients'
FROM
    doctor d
        JOIN
    patient p ON d.doctor_id = p.pcp_id
    group by d.doctor_name
    order by 'avg weight' desc;

-- 12. Who is the youngest person diagnosed with the flu?
-- Output just the name of the patient and their date of birth

SELECT 
    p.patient_name, p.dob
FROM
    patient p
WHERE
    p.dob = (SELECT 
            MAX(dob)
        FROM
            patient p
                JOIN
            diagnosis d USING (patient_id)
                JOIN
            disease dis USING (disease_id)
        WHERE
            dis.disease_name = 'flu');

-- 13. Show all diagnoses by doctors who are a general practitioners
-- Give patient name,  the diagnosis, the doctor's name, and the date
-- Order by the date

SELECT 
    p.patient_name,
    dis.disease_name,
    d.doctor_name,
    dia.diagnosis_date
FROM
    patient p
        LEFT JOIN
    diagnosis dia USING (patient_id)
        LEFT JOIN
    doctor d USING (doctor_id)
        LEFT JOIN
    disease dis USING (disease_id)
WHERE
    d.specialty_id = 1
ORDER BY dia.diagnosis_date DESC;

-- 14. The hospital wants to pair up doctors so that  doctors
-- mentor other doctors. Doctors can only mentor another doctor
-- in the same specialty. And they can't mentor themselves!
-- Find all the candidate mentor-mentee pairs.
-- Output the name of the mentor, the name of the mentee, and their shared specialty
-- Order by the mentor, then the mentee last name

SELECT 
    mentor.doctor_name AS 'mentor',
    mentee.doctor_name AS 'mentee',
    specialty_name
FROM
    doctor mentor
        JOIN
    specialty USING (specialty_id)
        JOIN
    doctor mentee USING (specialty_id)
WHERE
    mentor.doctor_name != mentee.doctor_name
ORDER BY mentor.doctor_name ASC , mentee.doctor_name ASC;


-- 15. What has the youngest patient been diagnosed with?
-- Output the disease and date of diagnosis
-- Order earliest to most recent diagnosis

select p.patient_name, dis.disease_name, dia.diagnosis_date
from patient p
left join diagnosis dia using (patient_id)
left join disease dis using (disease_id)
where p.dob = 
(Select Max(p.dob)
from patient p)
order by dia.diagnosis_date asc;


-- Remember to save your script as: CS3200_HW4_yourname.sql